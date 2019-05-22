package com.revature.web;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.model.Module;
//import com.revature.model.Tag;

public interface ModuleController {
	
	ResponseEntity<Module> createModule(Module module);
	List<Module> findAllModules();
	//List<Tag> findAllTags();
	ResponseEntity<Module> findModuleById(long moduleId);
	ResponseEntity<Module> findModuleByName(String moduleName);
	ResponseEntity<Module> updateModuleByModule(Module module);
	ResponseEntity<Module> deleteModuleByModule(Module module);
	 
    //List<Tag> findAllTags();
}
