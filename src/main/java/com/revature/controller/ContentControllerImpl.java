package com.revature.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.CreateContentDto;
import com.revature.model.Content;
import com.revature.model.Tag;
import com.revature.service.ContentService;
import com.revature.service.TagService;

@RestController("contentController")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(path = "/content")
public class ContentControllerImpl implements ContentController {
	
	@Autowired
	private ContentService contentService;

	@Autowired 
	private TagService tagService;
	

	/**
	 * Receives a content object and checks if the URL exists. If the URL does not exist the method places it 
	 * in the database as well as creating tags associated with that content ID. 
	 * If it does exist it will update the existing content
	 * Returns a response entity with a 200 HTTP status if the content is valid.
	 * Returns a response entity with a 400 HTTP status if the content object returns null
	 */
	@PostMapping("/register")
	public ResponseEntity<Content> createContent(@RequestBody CreateContentDto contentDto) {
		Content content = contentDto.getContent();
		Content checkContent = contentService.findByUrl(content.getUrl());
		
		if(checkContent != null) {
			System.out.println("enter if statement");
			
			Content validContent = contentService.updateContent(checkContent);
			return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			Content validContent = contentService.newContent(content);
			
			System.out.println("The valid content is : " + validContent);
			
			List<Tag> tags = tagService.createTagWithContentId(content.getContentId(), contentDto.getTags());
			
			validContent.setTags(tags);
			
			return (validContent != null) ?
					new ResponseEntity<>(contentService.findByContentId(content.getContentId()),HttpStatus.OK) :
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
	@PostMapping("/findbytag")
	public ResponseEntity<Set<Content>> findByTagsIgnoreCase(@RequestBody Tag[] tags) {
		Set<Content> validContent = contentService.findByTagsIgnoreCase(tags);
		return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Finds content with the given parameters tags and category
	 * Returns a response entity with a 200 HTTP status if the content is valid.
	 * Returns a response entity with a 400 HTTP status if the content object returns null
	 */
	@PostMapping("/findbytagsandcategory")
	public ResponseEntity<List<Content>> findByTagsAndCategory(@RequestBody Tag[] tags, @RequestParam("category") String category) {
		List<Content> validContent = contentService.findByTagsAndCategory(tags, category);
		return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * NOTE: NOT USED FOR THIS ITERATION
     *
     * NOTE TO FUTURE ITERATIONS:
     *         deleteContent requires you to delete Tags associated with the contentId because we are use cascade.all
	 * 
	 * Deletes specific content with corresponding to contentId
	 * Calls the content service method deleteContent(long contentId)
	 */
	
	@DeleteMapping("/delete")
	public void deleteContent(@RequestParam long contentId) {
		contentService.deleteContent(contentId);
	}

	/**
	 * Finds content with the given parameter category
	 * Returns a response entity with a 200 HTTP status if the content is valid.
	 * Returns a response entity with a 400 HTTP status if the content object returns null
	 */
	@GetMapping("/findbycategory")
	public ResponseEntity<Content> findByCategory(@RequestParam("category") String category) {
		Content validContent = contentService.findByCategory(category);
		return (validContent != null) ?
				new ResponseEntity<>(validContent,HttpStatus.OK) :
			    new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Finds all content 
	 * Returns a response entity with a 200 HTTP status if the content list is valid
	 * Returns a response entity with a 400 HTTP status if the content list is null
	 */
	@GetMapping("/findall")
	public ResponseEntity<List<Content>> findAllContent() {
		List<Content> allContent = contentService.findAllContent();
		return (allContent != null) ?
				new ResponseEntity<>(allContent, HttpStatus.OK) :
				new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
	
	/**
	 * 
	 * This GetMapping/endpoint is merely a fallback if the array of tags can't
	 * be populated in the content object itself
	 * 
	 * This endpoint returns a list of all tag objects that are associated
	 * with a certain content id.
	 * 
	 */
	@PostMapping("/findtagsbycontentid")
	public ResponseEntity<List<Tag>> findTagsByContentId(@RequestBody Content content) {
		List<Tag> allTags = contentService.findTagsByContentId(content.getContentId());
		return(allTags != null) ?
				new ResponseEntity<>(allTags, HttpStatus.OK) :
				new ResponseEntity<>(HttpStatus.NOT_FOUND);
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