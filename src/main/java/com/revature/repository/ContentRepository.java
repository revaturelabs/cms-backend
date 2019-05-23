package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Content;
import com.revature.model.Tag;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

	//public Content newContent(Content content);
	  public Content findByContentId(long contentId);
	  public Content findByUrl(String url);
	  public List<Content> findByTags(Tag tag);
	  public Content findByTagsAndCategory(Tag tag, String category);
	  public Content findByCategory(String category);
	//public void deleteContent();
}