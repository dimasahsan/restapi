package com.dimas.restapi.domain;

import java.util.List;

public interface NewsRepository {
	List<News> findAll();

	void saveNews(News news);

	void updateNews(News news);
	
	void deleteNews(Long id);
		
	List<News> findByStatus(Status status);
	
	List<News> findByTopic(Topic topic);
	
	News findById(Long id);
	
	List<News> findByTitle(String title);
}
