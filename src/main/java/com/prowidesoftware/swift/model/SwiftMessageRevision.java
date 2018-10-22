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
 * A revision is a snapshot of message content and is used to track the history of changes in a message.
 * Applications may use to store revisions each time a message is edited.
 *
 * <p>XML metadata may be used to override or augment these JPA annotations.
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8
 */
@Entity
@Table(name="swift_msg_revision")
public class SwiftMessageRevision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "creation_date")
	private Calendar creationDate = Calendar.getInstance();

	@Column(length = 40, name="creation_user")
	private String creationUser;

	@Lob
	private String message;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SwiftMessageRevision that = (SwiftMessageRevision) o;
		return Objects.equals(creationDate, that.creationDate) &&
				Objects.equals(creationUser, that.creationUser) &&
				Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(creationDate, creationUser, message);
	}

	@Lob
	@Basic(fetch=LAZY)
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

}
