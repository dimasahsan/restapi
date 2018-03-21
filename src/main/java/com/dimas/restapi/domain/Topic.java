package com.dimas.restapi.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.dimas.restapi.domain.base.EntityBase;

import javax.persistence.JoinColumn;

@Entity
public class Topic extends EntityBase<Topic> {
	private String name;

	@ManyToMany
	@JoinTable(name = "news_topic",
	joinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "news_id", referencedColumnName = "id"))
	private Set<News> news = new HashSet<News>();

	/** Necessary for JPA entities internally. */
	@SuppressWarnings("unused")
	private Topic() {
	}

	public Topic(final String name, Set<News> news) {
		this.name = name;
		this.news = news;
	}

	@Override
	public String toString() {
		return String.format("Topic{id=%d, name='%s'}", getId(), name);
	}

	public String getName() {
		return name;
	}
}
