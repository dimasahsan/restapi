package com.dimas.restapi.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dimas.restapi.application.TopicService;
import com.dimas.restapi.domain.Topic;
import com.dimas.restapi.domain.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService{
	
	@Autowired
	private TopicRepository topicRepo;
	
	@Override
	public List<Topic> findAll() {
		return topicRepo.findAll();
	}

	@Override
	public void saveTopic(Topic topic) {
		topicRepo.saveTopic(topic);
	}

	@Override
	public void updateTopic(Long id, Topic topic) {
		if(topicRepo.findById(id) != null){
			topicRepo.updateTopic(topic);
		}
	}

	@Override
	public void deleteTopic(Long id) {
		topicRepo.deleteTopic(id);
	}

	@Override
	public Topic findById(Long id) {
		return topicRepo.findById(id); 
	}

	@Override
	public List<Topic> findByNameContaining(String name) {
		return topicRepo.findByNameContaining(name);
	}

}
