package com.revature.model;
import java.util.Date;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "TAG")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TAG_ID")
	private long tagId;
	@Column(name = "TAG_NAME")
	private String tagName;
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

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "content_tag_jt", joinColumns = @JoinColumn(name = "tagId"), inverseJoinColumns = @JoinColumn(name = "contentId"))
	private Content content;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "module_tag_jt", joinColumns = @JoinColumn(name = "tagId"), inverseJoinColumns = @JoinColumn(name = "moduleId"))
	private Module modules;

	public Tag() {}
	


	public Tag(long tagId, String tagName, String type, long contentId, long moduleId, Date dateCreated,
			Date dateUpdated, Content content, Module modules) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.type = type;
		this.contentId = contentId;
		this.moduleId = moduleId;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.content = content;
		this.modules = modules;
	}



	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagName=" + tagName + ", type=" + type + ", contentId=" + contentId
				+ ", moduleId=" + moduleId + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated
				+ ", content=" + content + ", modules=" + modules + "]";
	}



	public long getTagId() {
		return tagId;
	}



	public void setTagId(long tagId) {
		this.tagId = tagId;
	}



	public String getTagName() {
		return tagName;
	}



	public void setTagName(String tagName) {
		this.tagName = tagName;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public long getContentId() {
		return contentId;
	}



	public void setContentId(long contentId) {
		this.contentId = contentId;
	}



	public long getModuleId() {
		return moduleId;
	}



	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}



	public Date getDateCreated() {
		return dateCreated;
	}



	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}



	public Date getDateUpdated() {
		return dateUpdated;
	}



	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}



	public Content getContent() {
		return content;
	}



	public void setContent(Content content) {
		this.content = content;
	}



	public Module getModules() {
		return modules;
	}



	public void setModules(Module modules) {
		this.modules = modules;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (int) (contentId ^ (contentId >>> 32));
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result + (int) (moduleId ^ (moduleId >>> 32));
		result = prime * result + ((modules == null) ? 0 : modules.hashCode());
		result = prime * result + (int) (tagId ^ (tagId >>> 32));
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Tag other = (Tag) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (contentId != other.contentId)
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateUpdated == null) {
			if (other.dateUpdated != null)
				return false;
		} else if (!dateUpdated.equals(other.dateUpdated))
			return false;
		if (moduleId != other.moduleId)
			return false;
		if (modules == null) {
			if (other.modules != null)
				return false;
		} else if (!modules.equals(other.modules))
			return false;
		if (tagId != other.tagId)
			return false;
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}

