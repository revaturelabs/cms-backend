package com.revature.service;

import com.revature.model.Module;


public interface ModuleService {

	Module createModule(Module Module);
	Module findModuleById(long id);
	Module findModuleByName(String name);
	Module updateModule(Module module);
	void deleteModule(Module module);
	
	//List<Tag> findAllTags(Tag tag);
	
}
