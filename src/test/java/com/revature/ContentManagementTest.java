package com.revature;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

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
	public void findByCategory_findByCategoryTest() {
		
	}
	
}
