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

import java.util.Calendar;

/**
 * Comments associated to a message for application only usage (not part of the standard).
 * 
 * @author www.prowidesoftware.com
 * @since 7.0
 */
public class SwiftMessageNote {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftMessageNote.class.getName());
	
	private Long id;
	private Calendar creationDate;
	private String creationUser;
	private String text;

	public SwiftMessageNote() {
	    super();
	}

	public SwiftMessageNote(String creationUser, String text) {
	    super();
	    this.creationDate = Calendar.getInstance();
	    this.creationUser = creationUser;
	    this.text = text;
	}
	
    /**
     * @return the id
     */
    public Long getId() {
    	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
    	this.id = id;
    }

    /**
     * @return the creationDate
     */
    public Calendar getCreationDate() {
    	return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Calendar creationDate) {
    	this.creationDate = creationDate;
    }

    public String getCreationUser() {
    	return creationUser;
    }

    public void setCreationUser(String creationUser) {
    	this.creationUser = creationUser;
    }

    /**
     * @return the text
     */
    public String getText() {
    	return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
    	this.text = text;
    }
	
}
