package com.revature.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Tag;
import com.revature.repository.TagRepository;

@Service
public class TagServiceImpl implements TagService {
	
	// Dependency
	@Autowired
	TagRepository tagRepository;
	
	/**
	 * Find All Tags Method:
	 * 1. Creates a list of tags.
	 * 2. Populates tags using enhanced for loop.
	 * 3. Returns the list of tags.
	 */
	public List<Tag> getAllTags() {
		List<Tag> tags = new ArrayList<Tag>();
		tagRepository.findAll().forEach(tag -> tags.add(tag));
		return tags;
	}
		
	/**
	 * Find Tag By ID Method:
	 * 1. Receives long value of id to search by.
	 * 2. If Tag has requested id, returns the Tag object.
	 * 3. If Tag does not have requested tags, returns a TagNotFoundException.
	 */
	public Tag getTagById(long id) {
        return tagRepository.findById(id).get();
		
    }

	/**
	 * Update Tag Method:
	 * 1. Receives Tag object with required changes to be updated.
	 * 2. Sets new Date object as Updated.
	 * 3. Saves the object replacing and updating the object.
	 */
    public void saveOrUpdate(Tag tag) {
    	tag.setUpdated(new Date());
        tagRepository.save(tag);
    }

    /**
     * Delete Tag Method:
	 * 1. Receives id as a long to specify tag to be deleted.
	 * 2. Deletes all tags with id given in the arguments.
     */
    public void delete(long id) {
        tagRepository.deleteById(id);
    }
}
