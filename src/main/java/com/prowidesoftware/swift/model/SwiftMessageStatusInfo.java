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
 * Status tracking record for application only usage (not part of the standard).<br />
 * The status name identifier is modeled with plain String, nevertheless 
 * the usage of an application specific enumeration is encourage; 
 * constructors and methods with raw Enum parameters are provided.
 * 
 * @author www.prowidesoftware.com
 * @since 7.0
 */
public class SwiftMessageStatusInfo implements Cloneable {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftMessageStatusInfo.class.getName());
	
	private Long id;
	private String name;
	private String comments;
	private Calendar creationDate;
	private String creationUser;

	/**
	 * Additional information regarding messages changes and manipulation through status changes
	 */
	private String data;

	/**
	 * No arguments constructor
	 */
	public SwiftMessageStatusInfo() {
		super();
		this.creationDate = Calendar.getInstance();	//this cannot be null, default to now
	}

	/**
	 * Constructor with parameter for all fields.
	 * @param comments optional user comments associated to the message
	 * @param creationDate date and time of status creation
	 * @param creationUser user that creates the status
	 * @param name status name
	 * @param data optional additional text data associated to the status processing
	 */
	public SwiftMessageStatusInfo(String comments, Calendar creationDate, String creationUser, String name, String data) {
		this();
		this.comments = comments;
		this.creationDate = creationDate;
		this.creationUser = creationUser;
		this.name = name;
		this.data = data;
	}
	
	/**
	 * @see #SwiftMessageStatusInfo(String, Calendar, String, String) 
	 * with null data.
	 */
	public SwiftMessageStatusInfo(String comments, Calendar creationDate, String creationUser, String name) {
		this(comments, creationUser, name, null);
	}
	
	/**
	 * @see #SwiftMessageStatusInfo(String, Calendar, String, String) 
	 * with creationDate initialized to now (Calendar.getInstance()).
	 */
	public SwiftMessageStatusInfo(String comments, String creationUser, String name, String data) {
		this(comments, Calendar.getInstance(), creationUser, name, data);
	}

	/**
	 * @see #SwiftMessageStatusInfo(String, Calendar, String, String) 
	 * with creationDate initialized to now (Calendar.getInstance()) and null data.
	 */
	public SwiftMessageStatusInfo(String comments, String creationUser, String name) {
		this(comments, Calendar.getInstance(), creationUser, name, null);
	}
	
	/**
	 * @see #SwiftMessageStatusInfo(String, Calendar, String, String)
	 * with Enum..name() and null data.
	 */
	@SuppressWarnings("rawtypes")
	public SwiftMessageStatusInfo(String comments, Calendar creationDate, String creationUser, Enum name) {
		this(comments, creationUser, name.name(), null);
	}
	
	/**
	 * @see #SwiftMessageStatusInfo(String, Calendar, String, String)
	 * with Enum..name(), creationDate initialized to now (Calendar.getInstance()).
	 */
	@SuppressWarnings("rawtypes")
	public SwiftMessageStatusInfo(String comments, String creationUser, Enum name, String data) {
		this(comments, Calendar.getInstance(), creationUser, name.name(), data);
	}

	/**
	 * @see #SwiftMessageStatusInfo(String, Calendar, String, String) 
	 * with Enum..name(), creationDate initialized to now (Calendar.getInstance()) and null data.
	 */
	@SuppressWarnings("rawtypes")
	public SwiftMessageStatusInfo(String comments, String creationUser, Enum name) {
		this(comments, Calendar.getInstance(), creationUser, name.name(), null);
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public Object clone() {
		SwiftMessageStatusInfo result = new SwiftMessageStatusInfo();
		result.setComments(getComments());
		result.setCreationDate(getCreationDate());
		result.setCreationUser(getCreationUser());
		result.setData(getData());
		result.setId(getId());
		result.setName(getName());
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((creationUser == null) ? 0 : creationUser.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SwiftMessageStatusInfo other = (SwiftMessageStatusInfo) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (creationUser == null) {
			if (other.creationUser != null)
				return false;
		} else if (!creationUser.equals(other.creationUser))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
