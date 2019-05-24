package com.revature.service;

import java.util.List;

import com.revature.model.Tag;

public interface TagService {

	List<Tag> findAllTags();
	Tag findTagById(long id);
	void save(Tag tag);
	void update(Tag tag);
	void deleteTag(Tag tag);
	Tag findByTagName(String name);
}
