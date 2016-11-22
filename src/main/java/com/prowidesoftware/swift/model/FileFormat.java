/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as 
 *     published by the Free Software Foundation, either version 3 of the 
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *     
 *     Check the LGPL at <http://www.gnu.org/licenses/> for more details.
 *******************************************************************************/
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
