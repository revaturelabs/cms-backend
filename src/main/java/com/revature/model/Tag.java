package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "TAG")
public class Tag {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TAG_ID")
	private long tagId;
	@Column(name = "TAG_NAME")
	private String name;
	@Column(name = "TYPE")
	private String type;
	@JoinColumn
	@Column(name = "CONTENT_ID")
	private long contentId;
	
	@JoinColumn
	@Column(name = "MODULE_ID")
	private long moduleId;
	
	@Column(name = "DATE_CREATED")

	@CreationTimestamp
	private Date dateCreated;
	@Column(name = "DATE_UPDATED")
	@UpdateTimestamp
	private Date dateUpdated;


	
	public Tag() {}
	
	public Tag(long tagId, String name, String type, long contentId, long moduleId, Date created, Date updated) {
		super();
		this.tagId = tagId;
		this.name = name;
		this.type = type;
		this.contentId = contentId;
		this.moduleId = moduleId;

		this.dateCreated = created;
		this.dateUpdated = updated;

	}
	
	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", name=" + name + ", type=" + type + ", contentId=" + contentId + ", moduleId="

				+ moduleId + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";

	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getContentId() {
		return contentId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}


	public Date getCreated() {
		return dateCreated;
	}

	public void setCreated(Date created) {
		this.dateCreated = created;
	}

	public Date getUpdated() {
		return dateUpdated;
	}

	public void setUpdated(Date updated) {
		this.dateUpdated = updated;
	}

}

