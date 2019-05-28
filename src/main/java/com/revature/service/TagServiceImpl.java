package com.revature.service;

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

	@Override
	public List<Tag> findAllTags() {
		return tagRepository.findAll();
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
		tagRepository.save(tag);
	}

	@Override
	public void update(Tag tag) {
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
				System.out.println(l.toString());
				tag.setModuleId(l);
				tagRepository.save(tag);
			}
		}
	}
}
