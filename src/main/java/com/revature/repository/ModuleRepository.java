package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    
    public Module findByModuleName(String name);
    
    //@Query()
    //List<tag>
    
 
}
