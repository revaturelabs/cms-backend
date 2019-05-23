package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Content;
import com.revature.model.Tag;
import com.revature.service.ContentService;

@RestController("contentController")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/content", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ContentControllerAlpha implements ContentController {
	
	@Autowired
	private ContentService contentService;

	@PostMapping("/register")
	public ResponseEntity<Content> createContent(@RequestBody Content content) {
		Content validContent = contentService.newContent(content);
		return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("findbyurl")
	public ResponseEntity<Content> findByURL(@RequestBody String url) {
		Content validContent = contentService.findByURL(url);
		return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("findbytag")
	public ResponseEntity<List<Content>> findByTag(@RequestBody Tag tags) {
		List<Content> validContent = contentService.findByTag(tags);
		return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("findbytagsandcategory")
	public ResponseEntity<Content> findByTagsAndCategory(@RequestBody Tag tags, String category) {
		Content validContent = contentService.findByTagsAndCategory(tags, category);
		return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("delete")
	public void deleteContent() {
		contentService.delete();
	}

	@PutMapping("update")
	public ResponseEntity<Content> updateContent(Content content) {
		Content validContent = contentService.updateContent(content);
		return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}
