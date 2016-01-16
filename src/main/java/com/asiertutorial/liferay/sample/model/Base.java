package com.asiertutorial.liferay.sample.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.envers.Audited;

@Audited
@MappedSuperclass
public abstract class Base implements Serializable {

	private static final long serialVersionUID = 3682667869584866683L;

	private Long userCreatorId;
	private Long userModifierId;
	private Date creationDate;
	private Date modifiedDate;
	private boolean active;

	@Column(name = "user_creator_id", nullable = false)
	public Long getUserCreatorId() {
		return userCreatorId;
	}

	public void setUserCreatorId(Long userCreatorId) {
		this.userCreatorId = userCreatorId;
	}

	@Column(name = "user_modifier_id", nullable = false)
	public Long getUserModifierId() {
		return userModifierId;
	}

	public void setUserModifierId(Long userModifierId) {
		this.userModifierId = userModifierId;
	}

	@Column(name = "creation_date", nullable = false)
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "modified_date", nullable = false)
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "active", nullable = false)
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
