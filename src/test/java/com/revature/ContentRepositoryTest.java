package com.revature;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class ContentRepositoryTest {
	
	@Autowired
	private ContentRepository contentRepository;
	
	@Autowired
    private TestEntityManager entityManager;
	
	
	@Test
	public void create_createTest() {
		Content content = null;
		content = newContent(content);
		Content entry =entityManager.persistAndFlush(content);
		
		Optional<Content> result = contentRepository.findById(content.getContentId());
		assertThat(result).isEqualTo(entry);
	} 
	


	private Content newContent(Content content) {
		 content = new Content();
		 content.setContentId(1);
		 content.setTags(null);
		 content.setDescription("notes about Java");
		 content.setCategory("notes");
		 content.setName("Java Notes");
		 content.setUrl("www.nowhere.com");
		 content.setDateCreated("2019-05-04");
		 content.setDateUpdated("2019-05-04");
		 
		 return content;
	}
	
//	@Test
//	public void findByCategory_findByCategoryTest() {
//		
//	}
//	
//	@Test
//	public void findByTag_findByTagTest() {
//		
//	}
//	
//	@Test
//	public void findByTagAndCategory_findByTagAndCategoryTest() {
//		
//	}
//	
//	@Test
//	public void findByUrl_findByUrlTest() {
////		Content url = new Content();
////		entityManager.persist(url);
////		entityManager.flush();
////		
////		Content found = contentRepository.findByURL(url.getUrl());
////		    assertThat(found.getName(), is(equalTo()));
//	}
//	
//	@Test 
//	public void delete_deleteTest() {
//		
//	}
//	
//	@Test
//	public void update_updateTest() {
//		
//	}
	
}
