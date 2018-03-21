package com.dimas.restapi.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dimas.restapi.application.NewsService;
import com.dimas.restapi.domain.News;
import com.dimas.restapi.domain.NewsRepository;
import com.dimas.restapi.domain.Status;
import com.dimas.restapi.domain.Topic;
import com.dimas.restapi.domain.TopicRepository;

@Service
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	private NewsRepository newsRepo;
	
	@Autowired
	private TopicRepository topicRepo;

	@Override
	public List<News> findAll() {
		return newsRepo.findAll();
	}

	@Override
	public void saveNews(News news) {
		newsRepo.saveNews(news);
	}

	@Override
	public void updateNews(Long id, News news) {
		if(newsRepo.findById(id) != null){
			newsRepo.updateNews(news);
		}
	}

	@Override
	public void deleteNews(Long id) {
		newsRepo.deleteNews(id);
	}

	@Override
	public List<News> findByStatus(String status) {
		if(status.equalsIgnoreCase(Status.DRAFT.toString())){
			return newsRepo.findByStatus(Status.DRAFT);
		} else if(status.equalsIgnoreCase(Status.DELETED.toString())){
			return newsRepo.findByStatus(Status.DRAFT);
		} else if (status.equalsIgnoreCase(Status.PUBLISH.toString())){
			return newsRepo.findByStatus(Status.DRAFT);
		}
		return null;
	}

	@Override
	public List<News> findByTopic(String name) {
		Topic topic = topicRepo.findByName(name);
		return newsRepo.findByTopic(topic);
	}

	@Override
	public News findById(Long id) {
		return newsRepo.findById(id);
	}

	@Override
	public List<News> findByTitle(String title) {
		return newsRepo.findByTitle(title);
	}

	

}
