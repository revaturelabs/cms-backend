package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Tag;


@Repository
public interface TagRepository extends JpaRepository<Tag,Long>{
	
	Tag findByTagName(String name);
	List<Long> findDistinctModuleIdByName(String tag);

}
