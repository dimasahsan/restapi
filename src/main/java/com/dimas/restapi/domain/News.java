package com.dimas.restapi.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.dimas.restapi.domain.base.EntityBase;

@Entity
public class News extends EntityBase<News> {
	private String title;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, 
	        CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "news_topic",
    joinColumns = @JoinColumn(name = "news_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id"))
	private Set<Topic> topics = new HashSet<Topic>();
	
	/**Necessary for JPA entities internally.*/
    @SuppressWarnings("unused")
	private News() {}
    
    public News(String title, Status status, Set<Topic> topics){
		this.title = title;
		this.status = status;
		this.topics = topics;
	}
    
    @Override
    public String toString() {
        return String.format(
                "News{id=%d, title='%s', status='%s'}",
                getId(), title, status, topics);
    }

	public String getTitle() {
		return title;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public Set<Topic> getTopics() {
		return topics;
	}
	
}
