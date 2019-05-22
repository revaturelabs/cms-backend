package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    
    Module findModuleByName(String name);

}
