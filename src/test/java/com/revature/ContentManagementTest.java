package com.revature;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Content;
import com.revature.repository.ContentRepository;
import com.revature.service.ContentService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContentManagementTest {
	
	@Autowired
	private ContentRepository contentRepository;
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired 
	private ContentService contentService;
	
	@Test
	public void create_createTest() {
		
	}
	
	@Test
	public void findByCategory_findByCategoryTest() {
		
	}
	
	@Test
	public void findByTag_findByTagTest() {
		
	}
	
	@Test
	public void findByTagAndCategory_findByTagAndCategoryTest() {
		
	}
	
	@Test
	public void findByUrl_findByUrlTest() {
//		Content url = new Content();
//		entityManager.persist(url);
//		entityManager.flush();
//		
//		Content found = contentRepository.findByURL(url.getUrl());
//		    assertThat(found.getName(), is(equalTo()));
	}
	
	@Test 
	public void delete_deleteTest() {
		
	}
	
	@Test
	public void update_updateTest() {
		
	}
	
}
