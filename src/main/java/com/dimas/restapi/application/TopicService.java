package com.dimas.restapi.application;

import java.util.List;

import com.dimas.restapi.domain.Topic;

public interface TopicService {
	List<Topic> findAll();

	void saveTopic(Topic topic);

	void updateTopic(Long id,Topic topic);
	
	void deleteTopic(Long id);
	
	Topic findById(Long id);
	
	List<Topic> findByNameContaining(String name);
}
