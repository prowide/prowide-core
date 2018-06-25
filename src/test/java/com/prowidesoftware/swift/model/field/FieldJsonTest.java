package com.prowidesoftware.swift.model.field;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test cases for fields JSON conversion
 * @since 7.10.2
 */
public class FieldJsonTest {

    private JsonParser parser = new JsonParser();

    @Test
    public void toJson() {
        Field32A f32A = new Field32A("010203USD123,45");
        //{"name":"32A","date":"010203","currency":"USD","amount":"123"}

        JsonObject o = parser.parse(f32A.toJson()).getAsJsonObject();
        assertEquals("32A", o.get("name").getAsString());
        assertEquals("010203", o.get("date").getAsString());
        assertEquals("USD", o.get("currency").getAsString());
        assertEquals("123,45", o.get("amount").getAsString());

        Field50D f50D = new Field50D("/D/1234\nFoo1\nFoo2\nFoo3");
        // {"name":"50D","dCMark":"D","account":"1234","nameAndAddress":"Foo1","nameAndAddress2":"Foo2","nameAndAddress3":"Foo3"}

        o = parser.parse(f50D.toJson()).getAsJsonObject();
        assertEquals("50D", o.get("name").getAsString());
        assertEquals("D", o.get("dCMark").getAsString());
        assertEquals("1234", o.get("account").getAsString());
        assertEquals("Foo1", o.get("nameAndAddress").getAsString());
        assertEquals("Foo2", o.get("nameAndAddress2").getAsString());
        assertEquals("Foo3", o.get("nameAndAddress3").getAsString());

        Field15A f15A = new Field15A();
        // {"name":"15A"}

        o = parser.parse(f15A.toJson()).getAsJsonObject();
        assertEquals("15A", o.get("name").getAsString());
        assertNull(o.get("value"));
    }

    @Test
    public void fromJson() {
        // check fromJson in specific Field classes
        String json32A = "{\"name\":\"32A\",\"date\":\"010203\",\"currency\":\"USD\",\"amount\":\"123,45\"}";
        Field32A f32A = Field32A.fromJson(json32A);
        assertEquals("010203", f32A.getDate());
        assertEquals("USD", f32A.getCurrency());
        assertEquals("123,45", f32A.getAmount());

        String json50D = "{\"name\":\"50D\",\"dCMark\":\"D\",\"account\":\"1234\",\"nameAndAddress\":\"Foo1\",\"nameAndAddress2\":\"Foo2\",\"nameAndAddress3\":\"Foo3\"}";
        Field50D f50D = Field50D.fromJson(json50D);
        assertEquals("D", f50D.getDCMark());
        assertEquals("1234", f50D.getAccount());
        assertEquals("Foo1", f50D.getNameAndAddressLine1());
        assertEquals("Foo2", f50D.getNameAndAddressLine2());
        assertEquals("Foo3", f50D.getNameAndAddressLine3());

        // check factory methods in Field
        Field32A f32Abis = (Field32A) Field.fromJson(json32A);
        assertEquals(f32A, f32Abis);
        Field50D f50Dbis = (Field50D) Field.fromJson(json50D);
        assertEquals(f50D, f50Dbis);
    }

}
