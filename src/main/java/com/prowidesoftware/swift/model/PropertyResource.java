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
package com.prowidesoftware.swift.model;

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import org.apache.commons.lang3.Validate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Common code for subclasses.
 *
 * @deprecated this class was meant to handle country and currency catalogs and it is no longer needed
 * in favor of native Java implementations in Currency and Locale
 * 
 * @since 3.3
 */
@Deprecated
@ProwideDeprecated(phase4=TargetYear.SRU2020)
public abstract class PropertyResource {
	private static final Logger log = Logger.getLogger(PropertyResource.class.getName());

	/**
	 * Property object to handle
	 */
	protected static final Properties prop = new Properties();

	/**
	 * Default constructor, loads the property file
	 */
	protected PropertyResource() {
		DeprecationUtils.phase2(getClass(), "constructor", "Implementation deprecated in favor of native Java implementations in Currency and Locale, use IsoUtils instead to validate currencies and countries");
		load();
	}


	private void load() {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(getResourceName());
		if (is!=null) {
			try {
				prop.load(is);
			} catch (IOException e) {
				log.log(Level.SEVERE, "Exception loading resource", e);
			}
		}
	}

	/**
	 * Gets the resource name for the managed property
	 * @return String containing the resource name
	 */
	protected abstract String getResourceName();
	

	/**
	 * Checks the parameter code in the managed prperty
	 * @param code key to look for in the properties
	 * @return true if the property contains <code>code</code> as key
	 */
	public boolean isValidCode(String code) {
		Validate.notNull(code);
		return prop.containsKey(code.toUpperCase());
	}
	
}
