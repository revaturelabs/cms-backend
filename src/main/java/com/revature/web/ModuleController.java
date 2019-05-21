package com.revature.web;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ModuleController {
	@Autowired
    private final ModuleService ModuleService;
    
    public ModuleController(ModuleService ModuleService) {
        this.ModuleService = ModuleService;
    }
    
    /*@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tag> findAllTags(Tag tag) {
        return ModuleService.findAllTags();
    }*/
    @GetMapping(value = "/Modules/{ModuleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findModuleById(@PathVariable("ModuleId") long moduleId) {
        try {
            Module module = ModuleService.findModuleById(moduleId);
            return ResponseEntity.ok(module);
        } catch (RuntimeException e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createModule(@RequestBody Module module) {
        try {
            Module created = ModuleService.createModule(module);
            return ResponseEntity.created(URI.create("/Modules/" + created.getModuleName())).build();
        } catch (RuntimeException e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
    
    @GetMapping(value = "/Modules/{ModuleName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findModuleByName(@PathVariable("ModuleName") String moduleName) {
        try {
            Module module = ModuleService.findModuleByName(moduleName);
            return ResponseEntity.ok(module);
        } catch (RuntimeException e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    //Module updateModule(Module module);
    @PutMapping(value = "/Modules/{ModuleUpdate}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateModuleByModule(@RequestBody Module module) {
        try {
            Module moduleUpdate = ModuleService.updateModule(module);
            return ResponseEntity.ok(moduleUpdate);
        } catch (RuntimeException e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }


    @DeleteMapping(value = "/Modules/{ModuleDelete}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteModuleByModule(@PathVariable("ModuleDelete") Module module) {
        try {
            ModuleService.deleteModule(module);
            return (ResponseEntity<?>) ResponseEntity.ok();
        } catch (RuntimeException e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}
