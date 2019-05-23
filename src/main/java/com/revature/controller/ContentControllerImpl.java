package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.CreateContentDto;
import com.revature.model.Content;
import com.revature.service.ContentService;

@RestController("contentController")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/content")
public class ContentControllerImpl implements ContentController {
	
	@Autowired
	private ContentService contentService;

	/**
	 * Receives a content object and checks if the URL exists. If the URL does not exist the method places it 
	 * in the database. If it does exist it will update the existing content
	 * Returns a response entity with a 200 HTTP status if the content is valid.
	 * Returns a response entity with a 400 HTTP status if the content object returns null
	 */
	@PostMapping("/register")
	public ResponseEntity<Content> createContent(@RequestBody CreateContentDto contentDto) {
		Content content = contentDto.getContent();
		Content checkContent = contentService.findByUrl(content.getUrl());
		if(checkContent != null) {
			Content validContent = contentService.updateContent(checkContent);
			return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			Content validContent = contentService.newContent(checkContent);
			return (validContent != null) ?
					new ResponseEntity<>(validContent,HttpStatus.OK) :
				    new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Finds content with corresponding URL. 
	 * Calls content service method findByURL(String url)
	 * Returns a response entity with a 200 HTTP status if the content is valid.
	 * Returns a response entity with a 400 HTTP status if the content object returns null 
	 */
	@GetMapping("/findbyurl")
	public ResponseEntity<Content> findByUrl(@RequestParam("url") String url) {
		Content validContent = contentService.findByUrl(url);
		return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Returns a list of contents with the given tags
	 * Returns a response entity with a 200 HTTP status if the content is valid.
	 * Returns a response entity with a 400 HTTP status if the content object returns null
	 */
	@GetMapping("/findbytag")
	public ResponseEntity<List<Content>> findByTag(@RequestParam("tag") String[] tags) {
		List<Content> validContent = contentService.findByTag(tags);
		return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Finds content with the given parameters tags and category
	 * Returns a response entity with a 200 HTTP status if the content is valid.
	 * Returns a response entity with a 400 HTTP status if the content object returns null
	 */
	@GetMapping("/findbytagsandcategory")
	public ResponseEntity<Content> findByTagsAndCategory(@RequestParam("tags") String[] tags, @RequestParam("category") String category) {
		Content validContent = contentService.findByTagsAndCategory(tags, category);
		return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Deletes specific content with corresponding to contentId
	 * Calls the content service method deleteContent(long contentId)
	 */
	@DeleteMapping("/delete")
	public void deleteContent(@RequestParam long contentId) {
		contentService.deleteContent(contentId);
	}

	/**
	 * Updates content with new content, should not be necessary if create business logic works
	 */
//	@PutMapping("/update")
//	public ResponseEntity<Content> updateContent(@RequestBody Content content) {
//		Content validContent = contentService.updateContent(content);
//		return (validContent != null) ?
//				new ResponseEntity<>(validContent,HttpStatus.OK) :
//			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
}