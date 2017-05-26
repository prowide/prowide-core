import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

import org.junit.Test;
import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.model.SwiftMessage;


public class BankFileParserTest {


    private SwiftParser bankFileParser = new SwiftParser();

    @Test
    public void shouldParseStatement() throws IOException {
        final Scanner scanner = new Scanner(BankFileParserTest.class.getResourceAsStream("smallStatement.STA"), Charset.defaultCharset()
                .name()).useDelimiter("\\Z");
        final String content = scanner.next();
        SwiftMessage parse = bankFileParser.parse(content);
        System.out.println(parse.getBlock4().getTags().size());
    }

    @Test
    public void shouldParseLargeFile() throws IOException {
        final Scanner scanner = new Scanner(BankFileParserTest.class.getResourceAsStream("largeStatement.STA"), Charset.defaultCharset()
                .name()).useDelimiter("\\Z");
        final String content = scanner.next();
        SwiftMessage parse = bankFileParser.parse(content);
        System.out.println(parse.getBlock4().getTags().size());
    }

}