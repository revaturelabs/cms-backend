package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


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
	@Column(name="TAGS")
	private List<Tag> tags;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="CATEGORY")
	private String category;
	@Column(name="CREATOR")
	private String creator;
	@Column(name="url")
	private String url;
	
	public Content() {
		
	}

	public Content(long contentId, List<Tag> tags, String description, String category, String creator, String url) {
		super();
		this.contentId = contentId;
		this.tags = tags;
		this.description = description;
		this.category = category;
		this.creator = creator;
		this.url = url;
	}

	public long getContentId() {
		return contentId;
	}

	public void setContentId(long contentId) {
		this.contentId = contentId;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contentId ^ (contentId >>> 32));
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		if (contentId != other.contentId)
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
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
		return "Content [contentId=" + contentId + ", description=" + description + ", category=" + category + ", creator="
				+ creator + ", url=" + url + "]";
	}
	
	
	
}
