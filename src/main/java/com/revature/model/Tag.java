package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAG")
public class Tag {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ailmentSequence")
	@SequenceGenerator(name="ailmentSequence",sequenceName="AILMENT_SEQ", allocationSize=1)
	@Column(name="TAG_ID")
	private long tagId;
	@Column(name = "TAG_NAME")
	private String name;
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "CONTENT_ID")
	private long contentId;
	@Column(name = "MODULE_ID")
	private long moduleId;
	@Column(name = "DATE_CREATED")
	private String created;
	@Column(name = "DATE_UPDATED")
	private String updated;
	
	
	
	
	public Tag() {}
	
	public Tag(long tagId, String name, String type, long contentId, long moduleId, String created, String updated) {
		super();
		this.tagId = tagId;
		this.name = name;
		this.type = type;
		this.contentId = contentId;
		this.moduleId = moduleId;
		this.created = created;
		this.updated = updated;
	}
	
	
	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", name=" + name + ", type=" + type + ", contentId=" + contentId + ", moduleId="
				+ moduleId + ", created=" + created + ", updated=" + updated + "]";
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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

}
