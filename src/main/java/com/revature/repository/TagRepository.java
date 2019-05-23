package com.revature.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.model.Tag;

public interface TagRepository extends JpaRepository<Tag,Long>{
	
	@Query(value="SELECT Module.moduleId FROM TAG INNER JOIN MODULE WHERE Tag.name=:tag", nativeQuery=true)
	Set<Long> findModuleIdsByTag(String tag);

}
