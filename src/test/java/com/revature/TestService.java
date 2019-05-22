package com.revature;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Content;
import com.revature.model.Tag;
import com.revature.service.ContentServiceImpl;

@Service
public class TestService {

	@Autowired	
	private ContentServiceImpl contentService;
	@Test
	public void testWorking() {
		String str = "Junit works";
		assertEquals("Junit works",str);
	}
	
	@Test
	public void testNewContent() {
		
		List<Tag> tags = new ArrayList<>();
		long str = System.currentTimeMillis();
		Date date = new Date(str);
		tags.add(new Tag(1, "Java", "type", 1, 1, "4-2-19", "4-3-19"));
		Content contentToCheck = new Content();
		assertEquals(contentService.newContent(contentToCheck), contentToCheck);
	}
}