package com.albummanager.model;

public class Comment {
	private int id;
	private int postId;
	private String name;
	private String emnail;
	private String body;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmnail() {
		return emnail;
	}
	public void setEmnail(String emnail) {
		this.emnail = emnail;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
