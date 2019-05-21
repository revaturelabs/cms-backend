package com.revature.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.revature.config.JpaConfig;
import com.revature.model.Tag;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = JpaConfig.class, loader = AnnotationConfigContextLoader.class)
@Transactional
public class TagRepositoryTest {

	@Autowired
	private TagRepository tagRepository;
	
	@Test
	public void testCreate() {
		Tag tag = new Tag();
		
		tagRepository.save(tag);
		
		assertThat(tagRepository.findAll().size()).isOne();
	}
	
	@Test
	public void testUpdate() {
		Tag tag = new Tag();
		
		tagRepository.save(tag);
		
		tag.setName("Java");
		
		assertThat(tagRepository.save(tag)).isNotNull();
	}
	
	@Test
	public void testDelete() {
		Tag tag = new Tag();
		
		tagRepository.save(tag);
		
		tagRepository.delete(tag);
		
		assertThat(tagRepository.findAll().size()).isZero();
	}
	
}
