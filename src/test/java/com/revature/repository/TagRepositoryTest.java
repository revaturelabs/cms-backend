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
	@Ignore
	public void testCreate() {
		Tag tag = new Tag();
		tag.setContentId(1L);
		tag.setCreated("5/22/2019");
		tag.setUpdated("5/22/2019");
		tag.setTagId(1);
		tag.setModuleId(1);
		tag.setType("belongsTo");
		tag.setName("Java");
		tagRepository.save(tag);
		
		assertThat(tagRepository.findAll().size()).isOne();
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		Tag tag = new Tag(1, "Beginning with Java", "Java", 1, 1, "5/20/2019", "5/21/2019");
		
		tagRepository.save(tag);
		
		tag.setName("Java");
		
		assertThat(tagRepository.save(tag)).isNotNull();
	}
	
	@Test
	public void testDelete() {
		Tag tag = new Tag(1, "Beginning with Java", "Java", 1, 1, "5/20/2019", "5/21/2019");
		
		tagRepository.save(tag);
		
		tagRepository.delete(tag);
		
		assertThat(tagRepository.findAll().size()).isZero();
	}
	
}
