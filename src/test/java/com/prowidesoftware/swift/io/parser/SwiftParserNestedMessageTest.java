/*
 * Copyright 2006-2026 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.prowidesoftware.swift.io.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftMessage;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * Test cases for rebuilding the message that travels nested in the block 4 of an MT021, MT056 or MT096, out of the
 * nested block tags and the single block parse methods in {@link SwiftParser}.
 */
public class SwiftParserNestedMessageTest {

    /**
     * Rebuilds a message out of the nested block tags of a tag list block 4.
     */
    private static SwiftMessage nestedMessage(SwiftBlock4 block4) {
        SwiftMessage nested = new SwiftMessage();
        if (block4.getTagByNumber(1) != null) {
            nested.addBlock(SwiftParser.parseBlock1(block4.getTagByNumber(1).getValue()));
        }
        if (block4.getTagByNumber(2) != null) {
            nested.addBlock(SwiftParser.parseBlock2(block4.getTagByNumber(2).getValue()));
        }
        if (block4.getTagByNumber(3) != null) {
            nested.addBlock(SwiftParser.parseBlock3(block4.getTagByNumber(3).getValue()));
        }
        if (block4.getTagByNumber(4) != null) {
            nested.addBlock(SwiftParser.parseBlock4(block4.getTagByNumber(4).getValue()));
        }
        if (block4.getTagByNumber(5) != null) {
            nested.addBlock(SwiftParser.parseBlock5(block4.getTagByNumber(5).getValue()));
        }
        return nested;
    }

    @Test
    void mt096CopiedMessageIsRebuiltFromTheNestedBlockTags() throws IOException {
        String fin = "{1:F01OURSGB33AXXX0000000000}"
                + "{2:O0961625170421ABLRXXXXGXXX00000000001704201625N}"
                + "{3:{103:CLH}{108:SWIFTBICAXXX0000890}}"
                + "{4:{1:F01PTY1US33AXXX0000000000}{2:I300PTY2GB33AXXXU3003}{3:{103:ABC}{108:MUR123}}{4:\r\n"
                + ":15A:\r\n"
                + ":20:R317703\r\n"
                + ":22A:NEWT\r\n"
                + "-}{5:{CHK:73AC90A7A3F1}{SYS:1309041018SMAIBE22AXXX0246001570}}}";

        SwiftMessage mt096 = SwiftMessage.parse(fin);
        assertThat(mt096.isType(96)).isTrue();

        SwiftMessage copied = nestedMessage(mt096.getBlock4());

        assertThat(copied.getBlock1()).isNotNull();
        assertThat(copied.getBlock1().getLogicalTerminal()).isEqualTo("PTY1US33AXXX");

        assertThat(copied.getBlock2()).isNotNull();
        assertThat(copied.getType()).isEqualTo("300");
        assertThat(copied.getBlock2().isInput()).isTrue();

        assertThat(copied.getBlock3()).isNotNull();
        assertThat(copied.getBlock3().size()).isEqualTo(2);
        assertThat(copied.getBlock3().getTagValue("103")).isEqualTo("ABC");
        assertThat(copied.getBlock3().getTagValue("108")).isEqualTo("MUR123");

        assertThat(copied.getBlock4()).isNotNull();
        assertThat(copied.getBlock4().size()).isEqualTo(3);
        assertThat(copied.getBlock4().getTagValue("15A")).isEmpty();
        assertThat(copied.getBlock4().getTagValue("20")).isEqualTo("R317703");
        assertThat(copied.getBlock4().getTagValue("22A")).isEqualTo("NEWT");

        assertThat(copied.getBlock5()).isNotNull();
        assertThat(copied.getBlock5().size()).isEqualTo(2);
        assertThat(copied.getBlock5().getTagValue("CHK")).isEqualTo("73AC90A7A3F1");
        assertThat(copied.getBlock5().getTagValue("SYS")).isEqualTo("1309041018SMAIBE22AXXX0246001570");
    }

    @Test
    void mt021RetrievedMessageIsRebuiltFromTheNestedBlockTags() throws IOException {
        String fin = "{1:F01VNDZBET2AXXX0000000000}{2:I021DYDYXXXXXXXXN}{4:"
                + "{202:0002}{203:0002}{280:1047010517VNDZBET2AXXX0026000410Y}{108:PRIORITY 2}"
                + "{1:F01PTY1US33AXXX0000000000}{2:I300PTY2GB33AXXXU3003}{3:{103:ABC}}{4:\r\n"
                + ":20:REF1\r\n"
                + "-}{5:{CHK:73AC90A7A3F1}}}";

        SwiftMessage mt021 = SwiftMessage.parse(fin);
        assertThat(mt021.isType(21)).isTrue();

        SwiftMessage retrieved = nestedMessage(mt021.getBlock4());

        assertThat(retrieved.getBlock1().getLogicalTerminal()).isEqualTo("PTY1US33AXXX");
        assertThat(retrieved.getType()).isEqualTo("300");
        assertThat(retrieved.getBlock3().getTagValue("103")).isEqualTo("ABC");
        assertThat(retrieved.getBlock4().getTagValue("20")).isEqualTo("REF1");
        assertThat(retrieved.getBlock5().getTagValue("CHK")).isEqualTo("73AC90A7A3F1");
    }

    @Test
    void mt056LoginBlockIsRebuiltFromTheField270Value() throws IOException {
        String fin = "{1:F01VNDZBET2AXXX0000000000}{2:I056DYDYXXXXXXXXN}{4:"
                + "{202:0001}{203:0001}{305:A}"
                + "{270:2410231030{1:F01VNDZBET2AXXX0000000000}{4:{110:001}{114:1}}}}";

        SwiftMessage mt056 = SwiftMessage.parse(fin);
        String loginAttempt = mt056.getBlock4().getTagValue("270");
        assertThat(loginAttempt).isEqualTo("2410231030{1:F01VNDZBET2AXXX0000000000}{4:{110:001}{114:1}}");

        // the login block is the value after the 10 characters timestamp
        String loginBlock = loginAttempt.substring(10);
        SwiftBlock4 asTagList = SwiftParser.parseBlock4(loginBlock.substring(loginBlock.indexOf("{4:")));

        assertThat(SwiftParser.parseBlock1(loginBlock.substring(0, loginBlock.indexOf("}") + 1))
                        .getLogicalTerminal())
                .isEqualTo("VNDZBET2AXXX");
        assertThat(asTagList.size()).isEqualTo(2);
        assertThat(asTagList.getTagValue("110")).isEqualTo("001");
        assertThat(asTagList.getTagValue("114")).isEqualTo("1");
    }
}
