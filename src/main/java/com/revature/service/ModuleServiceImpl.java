package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exception.ModuleNotFoundExceptions;
import com.revature.model.Module;
import com.revature.repository.ModuleRepository;

@Service
public class ModuleServiceImpl implements ModuleService {
	@Autowired
	private final ModuleRepository ModuleRepository;

	public ModuleServiceImpl(ModuleRepository ModuleRepository) {
		this.ModuleRepository = ModuleRepository;
	}

	// @Override
	// List<Tag> findAllTags(Tag tag) {
	// return ModuleRepository.findAll();
	// }

	@Override
	public Module createModule(Module Module) {
		return ModuleRepository.save(Module);
	}

	@Override
	public Module findModuleById(long id) {
		// The getOne method should just return one module based on the id that is
		// passed through
		// the .findById returns an Optional<Module> not what we wanted
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
	}
}
