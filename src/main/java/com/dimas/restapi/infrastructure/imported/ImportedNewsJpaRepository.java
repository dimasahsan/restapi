package com.dimas.restapi.infrastructure.imported;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dimas.restapi.domain.News;
import com.dimas.restapi.domain.Status;
import com.dimas.restapi.domain.Topic;

@Service
public interface ImportedNewsJpaRepository extends JpaRepository<News, Long> {

	List<News> findByStatus(Status status);
	
	List<News> findByTopics(Topic topic);

	News findById(Long id);

	List<News> findByTitleContaining(String title);

}
