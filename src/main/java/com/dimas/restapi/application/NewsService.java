package com.dimas.restapi.application;

import java.util.List;

import com.dimas.restapi.domain.News;
import com.dimas.restapi.domain.Status;
import com.dimas.restapi.domain.Topic;

public interface NewsService {
	List<News> findAll();

	void saveNews(News news);

	void updateNews(Long id,News news);
	
	void deleteNews(Long id);
	
	List<News> findByStatus(String status);
	
	List<News> findByTopic(String topic);
	
	News findById(Long id);
	
	List<News> findByTitle(String title);
	
}
