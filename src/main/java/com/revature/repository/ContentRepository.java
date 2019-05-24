package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.model.Content;
import com.revature.model.Tag;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

	
	public Content findByContentId(long contentId);

	public Content findByUrl(String url);

	@Query(value="SELECT new Content() FROM Content INNER JOIN Tag WHERE Tag.TAG_NAME = :name", nativeQuery = true)
	public List<Content> findByTags(@Param("name") String name);

	@Query(value="SELECT new Content() FROM Content INNER JOIN Tag WHERE Tag.TAG_NAME = :tag.getTagName() AND Content.category = :category", nativeQuery=true)
	public List<Content> findByTagsAndCategory(Tag tag, String category);

	public Content findByCategory(String category);
	
}