/* 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 */
package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;

import com.prowidesoftware.swift.model.Tag;

/**
 * Base implementation for field test cases
 * 
 * @author sebastian
 * @since 7.9.3
 */
@Ignore
public abstract class AbstractFieldTest {
	
    protected void testSerializationImpl(final String tagName, String ... values) {
    	try {
	    	for (String v : values) {
	    		Tag t1 = new Tag(tagName, v);
	    		Tag t2 = Field.getField(t1).asTag();;
	    		assertTrue("["+t1.getValue()+"] is not equals ["+t2.getValue()+"]", t1.equalsIgnoreCR(t2));
	    	}
    	} catch (Exception e) {
    		fail(e.getMessage());
    	}
    }
    
    /**
     * All subclasses must implement this test case calling {@link #testSerializationImpl(String, String...)}
     * to verify that a field value integrity is preserve after parsing it into components and serializing the
     * components back into a plain string. 
     */
    public abstract void testSerialization();

}
