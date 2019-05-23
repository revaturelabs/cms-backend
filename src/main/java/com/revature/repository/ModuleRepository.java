package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Module;
import com.revature.model.Tag;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    
    public Module findByModuleName(String name);
    
    @Query("SELECT TAG_NAME FROM TAG WHERE TAG.MODULE_ID = MODULE.moduleId")
    List<Tag> findAllTags();
    
 
}
