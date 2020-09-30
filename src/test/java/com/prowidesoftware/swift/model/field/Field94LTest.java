package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.Tag;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class Field94LTest extends AbstractFieldTest{

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("94L",
                ":ISSU//300300E1007142000089",
                ":ISSU//12345678AAAAAAAA99"
        );
    }

    @Test
    public void testParser1() {
        Field94L f = new Field94L(":ISSU//300300E1007142000089");
        Tag t = f.asTag();
        assertEquals("ISSU", f.getComponent1());
        assertEquals("300300E10071420000", f.getComponent2());
        assertEquals("89", f.getComponent3());
    }

    @Test
    public void testParser2() {
        Field94L f = new Field94L(":ISSU//300300E10071420000FOO");
        assertEquals("ISSU", f.getComponent1());
        assertEquals("300300E10071420000", f.getComponent2());
        assertEquals("FOO", f.getComponent3());
    }

    @Test
    public void testParser3() {
        Field94L f = new Field94L(":ISSU//ABCD1234");
        assertEquals("ISSU", f.getComponent1());
        assertEquals("ABCD1234", f.getComponent2());
        assertNull(f.getComponent3());
    }

    @Test
    public void testGetValueDisplay() {
        Field94L f = new Field94L(":ISSU//300300E1007142000089");
        assertNotNull(f.getValueDisplay(Locale.getDefault()));
        f = new Field94L(":ISSU//300300E100");
        assertNotNull(f.getValueDisplay(Locale.getDefault()));
        f = new Field94L(":ISSU//300300E1007142000089234234234");
        assertNotNull(f.getValueDisplay(Locale.getDefault()));
    }

}
