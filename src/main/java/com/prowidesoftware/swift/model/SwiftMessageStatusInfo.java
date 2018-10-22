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

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;

/**
 * Status tracking record for application only usage (not part of the standard).<br>
 * The status name identifier is modeled with plain String, nevertheless 
 * the usage of an application specific enumeration is encourage; 
 * constructors and methods with raw Enum parameters are provided.
 *
 * <p>XML metadata may be used to override or augment these JPA annotations.
 * 
 * @author www.prowidesoftware.com
 * @since 7.0
 */
@Entity
@Table(name="swift_msg_status")
public class SwiftMessageStatusInfo implements Cloneable {
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftMessageStatusInfo.class.getName());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String name;

	@Column(length = 200)
	private String comments;

	@Column(name = "creation_date")
	private Calendar creationDate = Calendar.getInstance();

	@Column(length = 40, name="creation_user")
	private String creationUser;

	/**
	 * Additional information regarding messages changes and manipulation through status changes.
	 * Intended for example to store JSON output from the process that generated the status. 
	 */
	@Lob
	@Basic(fetch=LAZY)
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
		if (creationDate != null) {
			this.creationDate = creationDate;
		}
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
		if (creationDate != null) {
			this.creationDate = creationDate;
		}
	}
	
	/**
	 * @see #SwiftMessageStatusInfo(String, Calendar, String, String)
	 * with Enum..name(), creationDate initialized to now (Calendar.getInstance()).
	 */
	@SuppressWarnings("rawtypes")
	public SwiftMessageStatusInfo(String comments, String creationUser, Enum name, String data) {
		this(comments, Calendar.getInstance(), creationUser, name.name(), data);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SwiftMessageStatusInfo that = (SwiftMessageStatusInfo) o;
		return Objects.equals(name, that.name) &&
				Objects.equals(comments, that.comments) &&
				Objects.equals(creationDate, that.creationDate) &&
				Objects.equals(creationUser, that.creationUser);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, comments, creationDate, creationUser);
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

	public SwiftMessageStatusInfo setName(String name) {
		this.name = name;
		return this;
	}

	public String getComments() {
		return comments;
	}

	public SwiftMessageStatusInfo setComments(String comments) {
		this.comments = comments;
		return this;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public SwiftMessageStatusInfo setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
		return this;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public SwiftMessageStatusInfo setCreationUser(String creationUser) {
		this.creationUser = creationUser;
		return this;
	}

	public String getData() {
		return data;
	}

	public SwiftMessageStatusInfo setData(String data) {
		this.data = data;
		return this;
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

}
