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
 * A revision is a snapshot of message content and is used to track the history of changes in a message.
 * Applications may use to store revisions each time a message is edited.
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8
 */
public class SwiftMessageRevision {
	private Long id;
	private Calendar creationDate = Calendar.getInstance();
	private String creationUser;
	private String message;
	private String json;

	public SwiftMessageRevision() {
		super();
	}

	/**
	 * Creates a message revision from a messages.<br> 
	 * Sets the revision message content with the actual message content. 
	 * And sets the revision creation date and creation user with information
	 * taken from the current status info. If the message has no status, this
	 * fields are left null. 
	 * @param msg message for the snapshot
	 */
	public SwiftMessageRevision(AbstractSwiftMessage msg) {
		super();
		SwiftMessageStatusInfo status = msg.getStatusInfo();
		if (status != null) {
			this.creationDate = status.getCreationDate();
			this.creationUser = status.getCreationUser();
		}
		this.message = msg.message();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((creationUser == null) ? 0 : creationUser.hashCode());
		result = prime * result + ((json == null) ? 0 : json.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		SwiftMessageRevision other = (SwiftMessageRevision) obj;
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
		if (json == null) {
			if (other.json != null)
				return false;
		} else if (!json.equals(other.json))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
}
