package com.asiertutorial.liferay.sample.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SAMPLE_COM_LOG_ACTION")
public class Action {

	private long actionId;
	private long userId;
	private Date actionDate;
	private String type;
	private String model;
	private long resourceId;
	private Class<?> parentEntityClass;
	private Serializable parentEntityId;

	public Action() {
		super();
	}

	public Action(long userId, Date actionDate, String type, String model,
			long resourceId) {
		this.userId = userId;
		this.actionDate = actionDate;
		this.type = type;
		this.model = model;
		this.resourceId = resourceId;
	}

	@Id
	@Column(name = "action_id")
	@SequenceGenerator(name = "seq_sample_action", sequenceName = "SEQ_SAMPLE_ACTION", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sample_action")
	public long getActionId() {
		return actionId;
	}

	public void setActionId(long actionId) {
		this.actionId = actionId;
	}

	@Column(name = "user_id", nullable = false)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "action_date", nullable = false)
	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "model", nullable = false)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "resource_id", nullable = false)
	public long getResourceId() {
		return resourceId;
	}

	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}

	@Column(name = "parentEntity_class")
	public Class<?> getParentEntityClass() {
		return parentEntityClass;
	}

	public void setParentEntityClass(Class<?> parentEntityClass) {
		this.parentEntityClass = parentEntityClass;
	}

	@Column(name = "parentEntity_id")
	public Serializable getParentEntityId() {
		return parentEntityId;
	}

	public void setParentEntityId(Serializable parentEntityId) {
		this.parentEntityId = parentEntityId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actionDate == null) ? 0 : actionDate.hashCode());
		result = prime * result + (int) (actionId ^ (actionId >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (int) (resourceId ^ (resourceId >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		Action other = (Action) obj;
		if (actionDate == null) {
			if (other.actionDate != null)
				return false;
		} else if (!actionDate.equals(other.actionDate))
			return false;
		if (actionId != other.actionId)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (resourceId != other.resourceId)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Action [actionId=");
		builder.append(actionId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", actionDate=");
		builder.append(actionDate);
		builder.append(", type=");
		builder.append(type);
		builder.append(", model=");
		builder.append(model);
		builder.append(", resourceId=");
		builder.append(resourceId);
		builder.append("]");
		return builder.toString();
	}

}
