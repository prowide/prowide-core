/*
 * Copyright 2006-2018 Prowide
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
