package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Tag;


@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
	
	
	Tag findByTagName(String name);
	List<Tag> findByContentId(long contentId);
	@Query(value = "SELECT DISTINCT module_Id FROM TAG WHERE tag_Name = :tag", nativeQuery = true)
	List<Long> findDistinctModuleIdByTagName(String tag);
	@Query(value = "SELECT DISTINCT * FROM TAG WHERE content_id is null ORDER BY TAG_NAME", nativeQuery = true)
	List<Tag> findAllDistinctTags();

}
