package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.model.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

	/**
	 * Returns content
	 * 
	 * @param contentId
	 * @return Content
	 */
//	@Query(value = "SELECT t.TAG_ID, t.TAG_NAME, t.TYPE, t.CONTENT_ID, t.MODULE_ID, "
//			+ "t.DATE_CREATED, t.DATE_UPDATED from Tag t INNER JOIN CONTENT c "
//			+ "ON t.CONTENT_ID  = :contentId", nativeQuery = true)
	public Content findByContentId(long contentId);

	public Content findByUrl(String url);

	/*
	 * SELECT DISTINCT c.CONTENTID, c.DESCRIPTION, c.CATEGORY, c.NAME, c.URL," +
	 * "c.DATE_CREATED, c.DATE_UPDATED FROM Content c INNER JOIN Tag t on t.content_id = c.contentid "
	 * + "WHERE t.TAG_NAME = :name"
	 * 
	 * This is the query needed for the oracle database testing
	 */
	@Query(value = "SELECT DISTINCT c.CONTENTID, c.DESCRIPTION, c.CATEGORY, c.NAME, c.URL,"
			+ "c.DATE_CREATED, c.DATE_UPDATED FROM Content c INNER JOIN Tag t ON c.CONTENTID = t.CONTENT_ID "
			+ "WHERE t.TAG_NAME ILIKE :name", nativeQuery = true)
	public List<Content> findByTagsIgnoreCase(@Param("name") String name);

	/*
	 * SELECT DISTINCT c.CONTENTID, c.DESCRIPTION, c.CATEGORY, c.NAME, c.URL," +
	 * "c.DATE_CREATED, c.DATE_UPDATED FROM Content c INNER JOIN Tag t on t.content_id = c.contentid "
	 * + "WHERE t.TAG_NAME = :name" AND c.CATEGORY = :category ,
	 */
	@Query(value = "SELECT DISTINCT c.CONTENTID, c.DESCRIPTION, c.CATEGORY, c.NAME, c.URL,"
			+ "c.DATE_CREATED, c.DATE_UPDATED FROM Content c INNER JOIN Tag t ON t.CONTENT_ID = c.CONTENTID "
			+ "WHERE t.TAG_NAME ILIKE :name AND c.CATEGORY ILIKE :category", nativeQuery = true)
	public List<Content> findByTagsAndCategory(@Param("name") String name, String category);

	public Content findByCategory(String category);

}