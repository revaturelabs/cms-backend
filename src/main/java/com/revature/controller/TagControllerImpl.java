package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Tag;
import com.revature.service.TagServiceImpl;

@RestController("tagController")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/tags", produces = { MediaType.APPLICATION_JSON_VALUE })
public class TagControllerImpl implements TagController {

	@Autowired
	TagServiceImpl tagService;

	@GetMapping("/getall")
	public ResponseEntity<List<Tag>> findAllTags() {
		List<Tag> allTags = tagService.findAllTags();
		return (allTags != null) ?
				new ResponseEntity<>(allTags, HttpStatus.FOUND) :
				new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getid/{tagId}")
	public ResponseEntity<Tag> findTagById(@PathVariable("tagId") long tagId) {
		Tag tagFound = tagService.findTagById(tagId);
		if (tagFound != null)
			return new ResponseEntity<>(tagFound, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	@GetMapping(value = "/getname/{name}")
	public ResponseEntity<Tag> findTagByName(@PathVariable("tagName") String tagName) {
		Tag tagFound = tagService.findByTagName(tagName);

		if (tagFound != null)
			return new ResponseEntity<>(tagFound, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/delete/{tagId}")
	public ResponseEntity<Tag> deleteTag(@RequestBody Tag tag) {
		if (tagService.findTagById(tag.getTagId()) != null) {
			tagService.deleteTag(tag);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<Long> createTag(@RequestBody Tag tag) {
		tagService.save(tag);
		Long id = tag.getTagId();
		return (id != null) ?
				new ResponseEntity<>(id, HttpStatus.CREATED) :
				new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update")
	public ResponseEntity<Long> updateTag(@RequestBody Tag tag) {
		tagService.save(tag);
		Long id = tag.getTagId();
		return (id != null) ?
				new ResponseEntity<>(id, HttpStatus.CREATED) :
				new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
