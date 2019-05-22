package com.revature;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Module;
import com.revature.repository.ModuleRepository;

@RunWith(SpringRunner.class)
@Transactional
@DataJpaTest
@Rollback(true)
public class ModuleTest {

	@Autowired
	private ModuleRepository moduleRepo;

	@Test
	public void testCreateModule() {
		Module module = null;
		module = newModule(module);
		Module entry = moduleRepo.save(module);
		assertThat(module).isEqualTo(entry);
	}

	private Module newModule(Module module) {
		module = new Module();
		module.setModuleId(1);
		module.setModuleName("Module 1");
		module.setActive(false);
		module.setCreated(new Date());
		module.setUpdated(new Date());
		return module;
	}

	@Test
	public void testFindAllModulesShouldReturnAll() {
		Module module = null;
		module = newModule(module);
		Module entry = moduleRepo.save(module);
		List<Module> modules = moduleRepo.findAll();
		assertEquals(1, modules.size());
	}

	@Test
	public void testFindModuleById() {
		Module module = null;
		module = newModule(module);
		Module entry = moduleRepo.save(module);
		Module newModule = moduleRepo.getOne(5L);
		assertThat(entry).isEqualTo(newModule);
	
	}
	
	@Test
	public void testFindByModuleName() {
		Module module = null;
		module = newModule(module);
		Module entry = moduleRepo.save(module);
		Module newModule = moduleRepo.findByModuleName("Module 1");
		assertThat(entry).isEqualTo(newModule);
	}

	@Test
	public void testUpdateModule() {
		Module module = new Module(0, "module1", true, null, new Date());
		module.setModuleName("newModuleName");
		moduleRepo.save(module);
		assertEquals("newModuleName", module.getModuleName());
	}

	@Test
	public void testDeleteModule() {
		Module module = new Module(0, "module2", true, new Date(), new Date());
		moduleRepo.delete(module);
		List<Module> modules = moduleRepo.findAll();
		assertEquals(0, modules.size());
	}

}