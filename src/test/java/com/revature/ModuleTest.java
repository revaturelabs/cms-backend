package com.revature;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Module;
import com.revature.repository.ModuleRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ModuleTest {

	@Autowired
	private ModuleRepository moduleRepo;

	@Test
	@Rollback(true)
	public void testCreateModule() throws SQLException {
		Module module = new Module(0, "module1", false, new Date(), new Date());
		moduleRepo.save(module);
		assertEquals("module1", module.getModuleName());
	}

	@Test
	public void testFindAllModulesShouldReturnAll() {
		List<Module> modules = moduleRepo.findAll();
		assertEquals(1, modules.size());
	}

	@Test
	public void testFindModuleByName() {
		Module module = moduleRepo.findModuleByName("moduleName");
		assertEquals("moduleName", module.getModuleName());
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