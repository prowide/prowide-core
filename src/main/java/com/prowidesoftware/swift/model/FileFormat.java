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

/**
 * Supported file formats in the {@link AbstractSwiftMessage} hierarchy.
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8.4
 */
/*
 * sebastian aug 2016: annotate subclasses?
 */
public enum FileFormat {
	/**
	 * SWIFT FIN message format
	 */
	FIN("fin"),
	/**
	 * Prowide CORE XML format
	 */
	CORE_XML("xml"),
	/**
	 * MQ-MT format
	 */
	MQ_MT("mt"),
	/**
	 * Only valid for MT.
	 * Remote Job Entry
	 */
	RJE("rje"),
	/**
	 * MX format 
	 */
	MX("xml"),
	/**
	 * Applies to both MT and MX
	 */
	XML_V2("xml");
	
	private String extension = null;
	
	FileFormat(final String extension) {
		this.extension = extension;
	}
	
	public String extension() {
		return this.extension;
	}
	
	public String label() {
		return "file-format."+name();
	}
}
