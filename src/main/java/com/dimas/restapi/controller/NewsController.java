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

import com.dimas.restapi.application.NewsService;
import com.dimas.restapi.domain.News;

@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<News>> getAllNews() {
		return new ResponseEntity<>(newsService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> saveNews(@RequestBody News news) {
		newsService.saveNews(news);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateNews(@PathVariable long id, @RequestBody News news) {
		newsService.updateNews(id, news);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteNews(@PathVariable long id) {
		newsService.deleteNews(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
	public ResponseEntity<Collection<News>> getNewsByStatus(@PathVariable String status) {
		List<News> news = newsService.findByStatus(status);
		if (news != null) {
			return new ResponseEntity<>(newsService.findByStatus(status), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/topic/{name}", method = RequestMethod.GET)
	public ResponseEntity<Collection<News>> getNewsByTopic(@PathVariable String name) {
		List<News> news = newsService.findByTopic(name);

		if (news != null) {
			return new ResponseEntity<>(newsService.findByTopic(name), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<News> getNewsById(@PathVariable Long id) {

		News news = newsService.findById(id);

		if (news != null) {
			return new ResponseEntity<>(newsService.findById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
	public ResponseEntity<Collection<News>> getNewsByTitle(@PathVariable String title) {

		List<News> news = newsService.findByTitle(title);

		if (news != null) {
			return new ResponseEntity<>(newsService.findByTitle(title), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
