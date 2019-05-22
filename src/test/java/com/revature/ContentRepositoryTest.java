package com.revature;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertThat;

/*import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;*/

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Content;
import com.revature.repository.ContentRepository;
//import com.revature.service.ContentService;
@Transactional
@RunWith(SpringRunner.class)
@DataJpaTest
public class ContentRepositoryTest {
	
	@Autowired
	private ContentRepository contentRepository;
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Ignore
	@Test
	public void create_createTest()  {
		Content content = null;
		content = newContent(content);
		Content entry = contentRepository.save(content);
		//Content entry =entityManager.persist(content);
		
		//Optional<Content> result = contentRepository.findById(content.getContentId());
		assertThat(content).isEqualTo(entry);
	} 
	
	private Content newContent(Content content) {
		 content = new Content();
		 content.setContentId(1);
		 
		 content.setDescription("notes about Java");
		 content.setCategory("notes");
		 content.setName("Java Notes");
		 content.setUrl("www.nowhere.com");
		 
		 
		 return content;
	}
	
	private Content checkContent(Content content) {
		 content = new Content();
		 content.setContentId(1);
		 
		 content.setDescription("notes about Java");
		 content.setCategory("notes");
		 content.setName("Java Notes");
		 content.setUrl("www.nowhere.com");
		
		 
		 return content;
	}
	
	private Content checkUrlContent(Content content) {
		 content = new Content();
		 content.setContentId(1);
		 
		 content.setDescription("notes about Java");
		 content.setCategory("notes");
		 content.setName("Java Notes");
		 content.setUrl("www.nowhere.com");
		 
		 
		 return content;
	}
	
	private Content checkIdContent(Content content) {
		 content = new Content();
		 content.setContentId(1);
		 
		 content.setDescription("notes about Java");
		 content.setCategory("notes");
		 content.setName("Java Notes");
		 content.setUrl("www.nowhere.com");
		
		 
		 return content;
	}
	
	@Test
	public void findByCategory_findByCategoryTest() {
		Content content = null;
		content = checkContent(content);
		Content entry = contentRepository.save(content);
		
		assertThat(entry).isEqualTo(contentRepository.findByCategory("notes"));
	}
	
	@Test
	public void findByIdTest() {
		Content content = null;
		content = checkIdContent(content);
		Content entry = contentRepository.save(content);
		assertThat(entry).isEqualTo(contentRepository.findByContentId(3));
	}
	
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
	@Test
	public void findByUrl_findByUrlTest() {
		Content content = null;
		content = checkUrlContent(content);
		Content entry = contentRepository.save(content);
		//contentRepository.findByUrl("www.nowhere.com");
		assertThat(entry).isEqualTo(contentRepository.findByUrl("www.nowhere.com"));
	}
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