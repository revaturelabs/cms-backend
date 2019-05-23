package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Tag;


@Repository
public interface TagRepository extends JpaRepository<Tag,Long>{
	
	@Query
	public Tag findByTagName(String name);

}
