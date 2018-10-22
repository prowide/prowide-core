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
package com.prowidesoftware.swift.io.writer;


import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

/**
 * @deprecated user {@link SwiftWriter} instead
 */
@Deprecated
@ProwideDeprecated(phase4=TargetYear._2019)
public class TextWriter 
{
    //private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger( TextWriter.class );

    /**
     * Creates a string with  a swift message for the given object.
     * The message type is selected in the template, which must point to a resource found in classapath.
     * 
     * @param template a valid path to the resource 
     * @param env the object to use to render the message
     * @return the string containing the encoded message
     * @throws IllegalArgumentException if template is null or the the template resource is not found in classpath
     */
    public String buildMessage( String template, Object env )
    {
        DeprecationUtils.phase3(getClass(), "buildMessage(String, Object)", "Use SwiftWriter instead.");
    	throw new UnsupportedOperationException("Use SwiftWriter");
    }
}
