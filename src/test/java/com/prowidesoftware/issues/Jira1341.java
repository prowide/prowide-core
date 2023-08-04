package com.prowidesoftware.issues;

import com.prowidesoftware.swift.model.field.Field50K;
import org.junit.jupiter.api.Test;

public class Jira1341 {

    @Test
    void testLogPollutionField50K() {
        // given
        Field50K field50K = new Field50K("/112224-55\n" + "AAA BBB\n" + "AAAAAAAA 10,2ND FLOOR\n" + "BBBBBBBBB 104");

        // when
        field50K.getValueDisplay();

        // then
        // Assertions.fail("see log pollution through exception...");
    }
}
