package com.revature.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Module;
import com.revature.service.ModuleService;

@RestController(value = "/Modules")
public class ModuleControllerImpl {
	
	@Autowired
    private final ModuleService ModuleService;
    
    public ModuleControllerImpl(ModuleService ModuleService) {
        this.ModuleService = ModuleService;
    }
    
    /*
     * @GetMapping(value = "/module/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tag> findAllTags() {
        return ModuleService.findAllTags();
    }
    */
    
    @PostMapping(value = "/module/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Module> createModule(@RequestBody Module module) {
        if(ModuleService.createModule(module) != null)
            return new ResponseEntity<>(module, HttpStatus.CREATED);
        else
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping(value = "/module/allModule", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Module> findAllModules(){
    	return ModuleService.findAllModules();
    }
    
    @GetMapping(value = "/module/{moduleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Module> findModuleById(@PathVariable("moduleId") long moduleId) {
        Module moduleFound = ModuleService.findModuleById(moduleId);
		if(moduleFound != null)
            return new ResponseEntity<>(moduleFound, HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping(value = "/module/{moduleName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Module> findModuleByName(@PathVariable("moduleName") String moduleName) {
        Module moduleFound = ModuleService.findByModuleName(moduleName);
        if(moduleFound != null)
            return new ResponseEntity<>(moduleFound, HttpStatus.FOUND);
        else
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @PutMapping(value = "/module/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Module> updateModuleByModule(@RequestBody Module module) {
        if(ModuleService.findModuleById(module.getModuleId()) != null) {
        	Module moduleUpdated = ModuleService.updateModule(module);
            return new ResponseEntity<>(moduleUpdated, HttpStatus.OK);
        }
        else
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping(value = "/module/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteModuleByModule(Module module) {
        if(ModuleService.findModuleById(module.getModuleId()) != null) {
            ModuleService.deleteModule(module);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}