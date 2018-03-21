package com.dimas.restapi.infrastructure;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dimas.restapi.domain.News;
import com.dimas.restapi.domain.NewsRepository;
import com.dimas.restapi.domain.Status;
import com.dimas.restapi.domain.Topic;
import com.dimas.restapi.infrastructure.imported.ImportedNewsJpaRepository;

@Service
public class NewsJpaRepository implements NewsRepository {
	
	private final ImportedNewsJpaRepository impl;
	
	@Autowired
    public NewsJpaRepository(final ImportedNewsJpaRepository impl) {
        this.impl = impl;
    }

	@Override
	public List<News> findAll() {
		return impl.findAll();
	}

	@Override
	public void saveNews(News news) {
		impl.save(news);
	}

	@Override
	public void updateNews(News news) {
		impl.save(news);
	}

	@Override
	public void deleteNews(Long id) {
		impl.delete(id);
	}
	
//	@Override
//	public void deleteNewsTopic(Long id) {
////		impl.delete(id);
//	}

	@Override
	public List<News> findByStatus(Status status) {
	return impl.findByStatus(status);
	}

	@Override
	public List<News> findByTopic(Topic topic) {
		return impl.findByTopics(topic);
	}

	@Override
	public News findById(Long id) {
		return impl.findById(id);
	}

	@Override
	public List<News> findByTitle(String title) {
		return impl.findByTitleContaining(title);
	}	
}