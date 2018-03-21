package com.dimas.restapi.domain;

import java.util.List;

public interface TopicRepository {
	List<Topic> findAll();
	
	void saveTopic(Topic topic);

	void updateTopic(Topic topic);
	
	void deleteTopic(Long id);
	
	Topic findById(Long id);
	
	List<Topic> findByNameContaining(String name);
	
	Topic findByName(String name);
}
