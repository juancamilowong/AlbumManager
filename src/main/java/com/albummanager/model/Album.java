package com.albummanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class Album {
	
	@Id
	private Integer id;
	
	@Column(name = "user_id")
	private int userId;
	private String title;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", userId=" + userId + ", title=" + title + "]";
	}
		
}
