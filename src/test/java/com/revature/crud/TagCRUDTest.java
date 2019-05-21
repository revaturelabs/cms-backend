package com.revature.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.revature.controller.TagController;
import com.revature.model.Tag;
import com.revature.repository.TagRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TagCRUDTest {
	
	@Autowired
	private TagRepository tagRepository;
	
	
	@Test
	public void testInputIntoRepository() {
		//contains: long tagId, String name, String type, long contentId, long moduleId, 
		//String dateCreated, String dateUpdated
		Tag tag = new Tag(1, "Beginning with Java", "Java", 1, 1, "5/20/2019", "5/21/2019");
		tagRepository.save(tag);
		
		Tag tag2 = new Tag(2, "Beginning with SQL", "SQL", 2, 2, "5/20/2019", "5/21/2019");
		tagRepository.save(tag2);

		Tag tag3 = new Tag(3, "Beginning with Angular", "Angular", 3, 3, "5/20/2019", "5/21/2019");
		tagRepository.save(tag3);

	}
	
	@Test
	public void testGetAll()
	{
		//TagController.getAllTags();
	}

}
