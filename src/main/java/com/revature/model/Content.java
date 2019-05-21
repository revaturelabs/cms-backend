package com.revature.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table
public class Content {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="contentSequence")
	@SequenceGenerator(name="contentSequence", sequenceName="CONTENT_SEQ", allocationSize=1)
	@Column(name="CONTENTID")
	private long contentId;
	/*
	 * One content to many Tags.
	 * Needing the info to eagerly fetch so that it gets current info
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name="content_tag_jt", joinColumns=@JoinColumn(name="contentId"), inverseJoinColumns=@JoinColumn(name="tagId"))
	@Column(name="DESCRIPTION")
	private String description;
	private List<Tag> tags;
	@Column(name="CATEGORY")
	private String category;
	@Column(name="NAME")
	private String name;
	@Column(name="URL")
	@Column(name="CATEGORY")
	private String category;
	@Column(name="CREATOR")
	private String creator;
	@Column(name="url")
	private String url;
	@Column(name="DATE_CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated; 
	@Column(name="DATE_UPDATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated; 
	
	public Content() {
		
	}

	public Content(long contentId, String description, List<Tag> tags, String category, String name, String url,
			Date dateCreated, Date dateUpdated) {
	public Content(long contentId, List<Tag> tags, String description, String category, String creator, String url) {
		super();
		this.contentId = contentId;
		this.description = description;
		this.tags = tags;
		this.category = category;
		this.name = name;
		this.category = category;
		this.creator = creator;
		this.url = url;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	public long getContentId() {
		return contentId;
	}

	public void setContentId(long contentId) {
		this.contentId = contentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + (int) (contentId ^ (contentId >>> 32));
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Content other = (Content) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Content [contentId=" + contentId + ", description=" + description + ", tags=" + tags + ", category="
				+ category + ", name=" + name + ", url=" + url + ", dateCreated=" + dateCreated + ", dateUpdated="
				+ dateUpdated + "]";
		return "Content [contentId=" + contentId + ", description=" + description + ", category=" + category + ", creator="
				+ creator + ", url=" + url + "]";
	}

	
	
	
	
}
