package com.revature.exception;

import java.util.List;

import com.revature.model.Tag;

public class ContentNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Overloaded ContentNotFoundException:
	 * 1. Receives contentId.
	 * 2. Returns message about the content with that id not found.
	 * @param contentId
	 */
	public ContentNotFoundException(long contentId) {
		System.out.println("Content with ID " + contentId + " not found");
	}

	/**
	 * Overloaded ContentNotFoundException:
	 * 1. Receives category.
	 * 2. Returns message about the content with that category not found.
	 * @param category
	 */
	public ContentNotFoundException(String category) {
		System.out.println("Content with category " + category + " not found");
	}
	
	/**
	 * Overloaded ContentNotFoundException:
	 * 1. Receives tags.
	 * 2. Returns message about the content with those tags not found.
	 * @param tags
	 */
	public ContentNotFoundException(List<Tag> tags) {
		System.out.println("Content with tag(s) " + tags + " not found");
	}
}
