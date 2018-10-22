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

/**
 * Comments associated to a message for application only usage (not part of the standard).
 *
 * <p>XML metadata may be used to override or augment these JPA annotations.
 * 
 * @author www.prowidesoftware.com
 * @since 7.0
 */
@Entity
@Table(name="swift_msg_note")
public class SwiftMessageNote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "creation_date")
	private Calendar creationDate;

	@Column(length = 40, name="creation_user")
	private String creationUser;

	@Lob
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
