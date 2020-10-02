package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.Tag;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class Field95LTest extends AbstractFieldTest{

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("95L",
                ":ISSU//300300E1007142000089",
                ":ISSU//12345678AAAAAAAA99"
        );
    }

    @Test
    public void testParser1() {
        Field95L f = new Field95L(":ISSU//300300E1007142000089");
        Tag t = f.asTag();
        assertEquals("ISSU", f.getComponent1());
        assertEquals("300300E10071420000", f.getComponent2());
        assertEquals("89", f.getComponent3());
    }

    @Test
    public void testParser2() {
        Field95L f = new Field95L(":ISSU//300300E10071420000FOO");
        assertEquals("ISSU", f.getComponent1());
        assertEquals("300300E10071420000", f.getComponent2());
        assertEquals("FOO", f.getComponent3());
    }

    @Test
    public void testParser3() {
        Field95L f = new Field95L(":ISSU//ABCD1234");
        assertEquals("ISSU", f.getComponent1());
        assertEquals("ABCD1234", f.getComponent2());
        assertNull(f.getComponent3());
    }

    @Test
    public void testGetValueDisplay() {
        Field95L f = new Field95L(":ISSU//300300E1007142000089");
        assertNotNull(f.getValueDisplay(Locale.getDefault()));
        f = new Field95L(":ISSU//300300E100");
        assertNotNull(f.getValueDisplay(Locale.getDefault()));
        f = new Field95L(":ISSU//300300E1007142000089234234234");
        assertNotNull(f.getValueDisplay(Locale.getDefault()));
    }

}
