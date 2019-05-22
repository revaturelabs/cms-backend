package com.revature.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Tag;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class TagRepositoryTest {

	@Autowired
	private TagRepository tagRepository;
	
	@Test
	public void testCreate() {				
		Tag tag = new Tag();
		tag.setContentId(1L);
		tag.setTagId(1);
		tag.setModuleId(1);
		tag.setType("belongsTo");
		tag.setName("Java");
		tagRepository.save(tag);
		
		System.err.println(tagRepository.findAll().get(0).toString());
		
		assertThat(tagRepository.findAll().size()).isOne();
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		Tag tag = new Tag();
		tag.setContentId(1L);
		tag.setTagId(1);
		tag.setModuleId(1);
		tag.setType("belongsTo");
		tag.setName("Java");
		
		tagRepository.save(tag);
		
		tag.setName("Java");
		
		assertThat(tagRepository.save(tag)).isNotNull();
	}
	
	@Test
	@Ignore
	public void testDelete() {
		Tag tag = new Tag();
		tag.setContentId(1L);
		tag.setTagId(1);
		tag.setModuleId(1);
		tag.setType("belongsTo");
		tag.setName("Java");
		
		tagRepository.save(tag);
		
		tagRepository.delete(tag);
		
		assertThat(tagRepository.findAll().size()).isZero();
	}
	
}
