package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exception.ModuleNotFoundExceptions;
import com.revature.model.Module;
import com.revature.model.Tag;
import com.revature.repository.ModuleRepository;
import com.revature.repository.TagRepository;

@Service
public class ModuleServiceImpl implements ModuleService {
	@Autowired
	private final ModuleRepository ModuleRepository;
	
	public ModuleServiceImpl(ModuleRepository ModuleRepository) {
		this.ModuleRepository = ModuleRepository;	
	}
	

	@Override
	public
	List<Tag> findAllTags() {
		return ModuleRepository.findAllTags();
	}

	@Override
	public Module createModule(Module Module) {
		return ModuleRepository.save(Module);
	}

	public List<Module> findAllModules() {
		return ModuleRepository.findAll();
	}

	@Override
	public Module findModuleById(long id) {
		return ModuleRepository.getOne(id);
	}

	@Override
	public Module findByModuleName(String name) {
		try {
			return ModuleRepository.findByModuleName(name);
		} catch (ModuleNotFoundExceptions e) {
			throw new ModuleNotFoundExceptions(name);
		}
	}

	@Override
	public Module updateModule(Module module) {
		return ModuleRepository.save(module);
	}

	@Override
	public void deleteModule(Module module) {
		ModuleRepository.delete(module);
		;
	}
}