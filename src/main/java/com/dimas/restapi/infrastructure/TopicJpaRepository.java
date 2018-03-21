package com.dimas.restapi.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dimas.restapi.domain.Topic;
import com.dimas.restapi.domain.TopicRepository;
import com.dimas.restapi.infrastructure.imported.ImportedTopicJpaRepository;

@Service
public class TopicJpaRepository implements TopicRepository {
	
private final ImportedTopicJpaRepository impl;
	
	@Autowired
    public TopicJpaRepository(final ImportedTopicJpaRepository impl) {
        this.impl = impl;
    }

	@Override
	public List<Topic> findAll() {
		return impl.findAll();
	}

	@Override
	public void saveTopic(Topic topic) {
		impl.save(topic);
	}

	@Override
	public void updateTopic(Topic topic) {
		impl.save(topic);		
	}

	@Override
	public void deleteTopic(Long id) {
		impl.delete(id);
	}

	@Override
	public Topic findById(Long id) {
		return impl.findById(id);
	}

	@Override
	public List<Topic> findByNameContaining(String name) {
		return impl.findByNameContaining(name); 
	}
	
	@Override
	public Topic findByName(String name){
		return impl.findByName(name);
	}

}
