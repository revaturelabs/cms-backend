package com.revature.service;

import java.util.List;

import com.revature.model.Tag;

public interface TagService {

	List<Tag> findAllTags();
	Tag findTagById(long id);
	//void saveOrUpdate(Tag tag);
	void deleteTag(Tag tag);
	Tag findByTagName(String name);
}
