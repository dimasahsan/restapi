package com.dimas.restapi.infrastructure.imported;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.dimas.restapi.domain.Topic;

@Service
public interface ImportedTopicJpaRepository extends JpaRepository<Topic, Long>{
	List<Topic> findAll();
	
	@Query("update Topic t set t.name=?2 where t.id = ?1")
	void updateTopic(Long id,Topic topic);
	
	Topic findById(Long id);
	
	List<Topic> findByNameContaining(String name);
	
	Topic findByName(String name);
}
