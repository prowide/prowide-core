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
package com.prowidesoftware.swift.model.mx;

import com.prowidesoftware.swift.model.MxId;

/**
 * Interface to plug in code that reads XML strings into MX message objects
 *
 * @since 7.6
 */
public interface MxRead {

	/**
	 * Read <code>xml</code> into a message object
	 *
	 * @param targetClass class of the message to be read
	 * @param xml the string with the message
	 * @param classes classes for the context
	 * @return parsed message or null if string content could not be parsed into an Mx
	 * 
	 * @since 7.6
	 */
	AbstractMX read(Class<? extends AbstractMX> targetClass, final String xml, Class<?>[] classes);

	/**
	 * Read <code>xml</code> into a message object
	 * 
	 * @param xml the string with the message
	 * @param id optional parameter to indicate the specific MX type to create; auto detected from namespace if null.
	 * @return parsed message or null if string content could not be parsed into an Mx
	 * 
	 * @since 7.8.4
	 */
	AbstractMX read(final String xml, MxId id);

}