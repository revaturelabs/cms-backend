package com.revature.service;

import java.util.List;

import com.revature.model.Module;


public interface ModuleService {

	Module createModule(Module Module);
	List<Module> findAllModules();
	Module findModuleById(long id);
	Module findByModuleName(String name);
	Module updateModule(Module module);
	void deleteModule(Module module);
	
	//List<Tag> findAllTags(Tag tag);
	
}
