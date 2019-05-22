package com.revature.model;
import java.util.Date;
<<<<<<< HEAD

import javax.persistence.CascadeType;
=======
>>>>>>> 82a66d9b688777e8ed8b3f0e4de65b82696b2ef5
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
<<<<<<< HEAD
	
	@Column(name = "CONTENT_ID")
	private long contentId;
	
=======
	@Column(name = "CONTENT_ID")
	private long contentId;
>>>>>>> 82a66d9b688777e8ed8b3f0e4de65b82696b2ef5
	@Column(name = "MODULE_ID")
	private long moduleId;
	@Column(name = "DATE_CREATED")
<<<<<<< HEAD

	@CreationTimestamp
	private Date dateCreated;
	@Column(name = "DATE_UPDATED")
	@UpdateTimestamp
	private Date dateUpdated;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="content_tag_jt", joinColumns=@JoinColumn(name="tagId"), inverseJoinColumns=@JoinColumn(name="contentId"))
	private Content content;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="module_tag_jt", joinColumns=@JoinColumn(name="tagId"), inverseJoinColumns=@JoinColumn(name="moduleId"))
	private Module modules;


=======
	private String dateCreated;
	@Column(name = "DATE_UPDATED")
	private String dateUpdated;
>>>>>>> 82a66d9b688777e8ed8b3f0e4de65b82696b2ef5
	
	public Tag() {}
	
	public Tag(long tagId, String name, String type, long contentId, long moduleId, String created, String updated) {
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

	public String getCreated() {
		return dateCreated;
	}

	public void setCreated(String created) {
		this.dateCreated = created;
	}

	public String getUpdated() {
		return dateUpdated;
	}

	public void setUpdated(String updated) {
		this.dateUpdated = updated;
	}

}

