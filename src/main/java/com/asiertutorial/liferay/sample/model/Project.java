package com.asiertutorial.liferay.sample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(	name = "CUSTOM_V2_PROJECT")
//@GenericGenerator(name = "LiferayStrategy", strategy = "com.asiertutorial.liferay.core.hibernate.LiferayCounterGenerator")
public class Project implements java.io.Serializable {

	private static final long serialVersionUID = -6430077981599333475L;

	private long 		projectId;
	private long 		companyId;
	private long 		groupId;
	private Date 		createDate;
	private Date 		modifiedDate;
	private String 		title;
	private int 		members;
	private Date 		deliveryDate;
	private String 		technologies;
	private boolean 	external;

	@Id
	@Column(name = "project_id")
	@SequenceGenerator(name = "seq_project", sequenceName = "SEQ_PROJECT", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_project")
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	@Column(name = "company_id")
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	@Column(name = "group_id")
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "modified_date")
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "members")
	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	@Column(name = "delivery_date")
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Column(name = "technologies")
	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

	@Column(name = "external")
	public boolean isExternal() {
		return external;
	}

	public void setExternal(boolean external) {
		this.external = external;
	}

}
