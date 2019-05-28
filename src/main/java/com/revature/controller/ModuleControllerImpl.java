package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Module;
import com.revature.service.ModuleService;

@RestController("moduleController")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(path = "/module")
public class ModuleControllerImpl {

	@Autowired
	private final ModuleService ModuleService;

	public ModuleControllerImpl(ModuleService ModuleService) {
		this.ModuleService = ModuleService;
	}

	@GetMapping(value = "/alltags")
	public ResponseEntity<List<String>> findAllTags() {
		List<String> allModuleTags = ModuleService.findAllTags();
		return (allModuleTags != null) ?
			new ResponseEntity<>(allModuleTags,HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Module> createModule(@RequestBody Module module) {
		if (ModuleService.createModule(module) != null)
			return new ResponseEntity<>(module, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/allmodules")
	public ResponseEntity<List<Module>> findAllModules() {
		List<Module> allModules = ModuleService.findAllModules();
		return (allModules != null) ?
				new ResponseEntity<>(allModules, HttpStatus.OK) :
				new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/getid/{moduleId}")
	public ResponseEntity<Module> findModuleById(@PathVariable("moduleId") long moduleId) {
		Module moduleFound = ModuleService.findModuleById(moduleId);
		if (moduleFound != null)
			return new ResponseEntity<>(moduleFound, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/getname/{moduleName}")
	public ResponseEntity<Module> findModuleByName(@PathVariable("moduleName") String moduleName) {
		Module moduleFound = ModuleService.findByModuleName(moduleName);
		if (moduleFound != null)
			return new ResponseEntity<>(moduleFound, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Module> updateModuleByModule(@RequestBody Module module) {
		if (ModuleService.findModuleById(module.getModuleId()) != null) {
			Module moduleUpdated = ModuleService.updateModule(module);
			return new ResponseEntity<>(moduleUpdated, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<?> deleteModuleByModule(@RequestBody Module module) {
		if (ModuleService.findModuleById(module.getModuleId()) != null) {
			ModuleService.deleteModule(module);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}