package com.revature.service;

import java.util.List;

import com.revature.model.Tag;

public interface TagService {

	List<Tag> getAllTags();
	Tag getTagById(long id);
	void saveOrUpdate(Tag tag);
	void delete(long id);
	void createTagWithContentId(long contentId, String[] tags);
}
