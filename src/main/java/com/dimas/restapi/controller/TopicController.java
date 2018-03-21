package com.dimas.restapi.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dimas.restapi.application.TopicService;
import com.dimas.restapi.domain.Topic;

@RestController
@RequestMapping("/topic")
public class TopicController {
	
	@Autowired
	private TopicService topicService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Topic>> getAllTopic() {
		return new ResponseEntity<>(topicService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> saveTopic(@RequestBody Topic topic) {
		topicService.saveTopic(topic);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateTopic(@PathVariable long id, @RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTopic(@PathVariable long id) {
		topicService.deleteTopic(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
		
		Topic topic = topicService.findById(id);

		if (topic != null) {
			return new ResponseEntity<>(topicService.findById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<Collection<Topic>> getTopicByTitle(@PathVariable String name) {
		
		List<Topic> topic = topicService.findByNameContaining(name);

		if (topic != null) {
			return new ResponseEntity<>(topicService.findByNameContaining(name), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
