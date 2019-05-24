package com.revature.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exception.TagNotFoundExceptions;
import com.revature.model.Tag;
import com.revature.repository.TagRepository;

@Service
public class TagServiceImpl implements TagService {

	// Dependency
	@Autowired
	TagRepository tagRepository;

	// private static Logger logger= Logger.getLogger();

	@Override
	public List<Tag> findAllTags() {
		List<Tag> tags = new ArrayList<Tag>();
		tagRepository.findAll().forEach(tag -> tags.add(tag));

		return tags;
	}

	@Override
	public Tag findTagById(long id) {
		return tagRepository.findById(id).get();
	}

	@Override
	public Tag findByTagName(String name) {
		try {
			return tagRepository.findByTagName(name);
		} catch (TagNotFoundExceptions e) {
			throw new TagNotFoundExceptions(name);
		}
	}

	@Override
	public void save(Tag tag) {
		tag.setDateCreated(new Date());
		tagRepository.save(tag);
	}

	@Override
	public void update(Tag tag) {
		tag.setDateUpdated(new Date());
		tagRepository.save(tag);
	}
	
	@Override
	public void deleteTag(Tag tag) {
		tagRepository.delete(tag);
	}

	@Override
	public void createTagWithContentId(long contentId, String[] tags) {
		Tag tag = new Tag();
		tag.setContentId(contentId);
		tag.setType("belongsTo");
		for(String t : tags) {
			tag.setTagName(t);
			for(Long l: tagRepository.findDistinctModuleIdByTagName(t)) {
				
				
				tag.setModuleId(l);
				tagRepository.save(tag);
			}
		}
	}
}
