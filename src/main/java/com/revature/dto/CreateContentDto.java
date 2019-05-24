package com.revature.dto;

import java.util.Arrays;

import com.revature.model.Content;

public class CreateContentDto {

	private Content content;
	private String[] tags;
	
	public CreateContentDto() {}

	public CreateContentDto(Content content, String[] tags) {
		super();
		this.content = content;
		this.tags = tags;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "CreateContentDto [content=" + content + ", tags=" + Arrays.toString(tags) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + Arrays.hashCode(tags);
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
		CreateContentDto other = (CreateContentDto) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (!Arrays.equals(tags, other.tags))
			return false;
		return true;
	}
	
	
}
