package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Tag;


@Repository
public interface TagRepository extends JpaRepository<Tag,Long>{
	
	Tag findByTagName(String name);
	@Query(value = "SELECT DISTINCT module_Id FROM TAG WHERE tag_Name = :tag", nativeQuery = true)
	List<Long> findDistinctModuleIdByTagName(String tag);

}
