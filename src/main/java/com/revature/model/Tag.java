package com.revature.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name ="TAG")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TAG_ID")
	private long tagId;
	@Column(name = "TAG_NAME")
	private String name;
	@Column(name = "TYPE")
	private String type;


	@Column(name = "contentId")
	private long contentId;


	@Column(name = "moduleId")
	private long moduleId;

	@Column(name = "DATE_CREATED")
	@CreationTimestamp
	private Date dateCreated;

	@Column(name = "DATE_UPDATED")
	@UpdateTimestamp
	private Date dateUpdated;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="moduleId", insertable=false, updatable=false)
	private Content content;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="moduleId", insertable=false, updatable=false)
	private Module modules;

	/**
	 * Default Constructor
	 */
	public Tag() {}
	
	/**
	 * Constructor with fields
	 * @param tagId long primitive
	 * @param name String object
	 * @param type String object
	 * @param contentId long primitive
	 * @param moduleId long primitive
	 * @param created Date object
	 * @param updated Date object
	 */
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
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", name=" + name + ", type=" + type + ", contentId=" + contentId + ", moduleId="

				+ moduleId + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";

	}

	/**
	 * Getter for tagId:
	 * 1. Retrieves tagId property of Tag object.
	 * @return tagId long primitive
	 */
	public long getTagId() {
		return tagId;
	}

	/**
	 * Setter for tagId:
	 * 1. Receives tagId as a long.
	 * 2. Sets the tagId property of Tag object to long value of tagId.
	 * @param tagId long primitive
	 */
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	/**
	 * Getter for name:
	 * 1. Retrieves name property of Tag object.
	 * @return name String object
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name:
	 * 1. Receives name as a String.
	 * 2. Sets the name property of Tag object to String value of name.
	 * @param name String object
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for type:
	 * 1. Retrieves type property of Tag object.
	 * @return type String object
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter for type:
	 * 1. Receives type as a String.
	 * 2. Sets the type property of Tag object to String value of type.
	 * @param type String object
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter for contentId:
	 * 1. Retrieves contentId property of Tag object.
	 * @return contentId Long object
	 */
	public Long getContentId() {
		return contentId;
	}

	/**
	 * Setter for contentId:
	 * 1. Receives contentId as a Long wrapper class object named contentId.
	 * 2. Sets the contentId property of Tag object to contentId Long object.
	 * @param contentId Long object
	 */
	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

	/**
	 * Getter for moduleId:
	 * 1. Retrieves moduleId property of Tag object.
	 * @return moduleId long primitive
	 */
	public long getModuleId() {
		return moduleId;
	}

	/**
	 * Setter for moduleId:
	 * 1. Receives moduleId as a long.
	 * 2. Sets the moduleId property of Tag object to moduleId long value.
	 * @param moduleId long primitive
	 */
	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * Getter for dateCreated:
	 * 1. Retrieves dateCreated property of Tag object.
	 * @return dateCreated Date object
	 */
	public Date getCreated() {
		return dateCreated;
	}

	/**
	 * Setter for dateCreated:
	 * 1. Receives Date object named created
	 * 2. Sets the dateCreated property of Tag object to created Date object.
	 * @param created Date object
	 */
	public void setCreated(Date created) {
		this.dateCreated = created;
	}

	/**
	 * Getter for dateUpdated:
	 * 1. Retrieves dateUpdated property of Tag object.
	 * @return dateUpdated Date object
	 */
	public Date getUpdated() {
		return dateUpdated;
	}

	/**
	 * Setter for dateUpdated:
	 * 1. Receives Date object named updated
	 * 2. Sets the dateUpdated property of Tag object to updated Date object.
	 * @param updated Date object
	 */
	public void setUpdated(Date updated) {
		this.dateUpdated = updated;
	}
}
