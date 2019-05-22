package com.revature.controller;

import java.util.List;

import com.revature.model.Tag;

public interface TagController {

	List<Tag> getAllTags();
	Tag getTag(long id);
	void deleteTag(long id);
	long createTag(Tag tag);
	long updateTag(Tag tag);
}
