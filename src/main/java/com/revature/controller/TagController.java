package com.revature.controller;

import java.util.List;

import com.revature.model.Tag;

public interface TagController {

	List<Tag> getAllTags();
	Tag getTag(int id);
	void deleteTag(int id);
	long saveTag(Tag tag);
}
