package com.revature.service;

import java.util.List;

import com.revature.model.Tag;

public interface TagService {

	List<Tag> getAllTags();
	Tag getTagById(long id);
	void save(Tag tag);
	void update(Tag tag);
	void delete(long id);
}
