package com.albummanager.service;

import java.util.List;

import com.albummanager.model.Comment;

public interface ICommentService {
	
	public List<Comment> getAllcomments();
	public Comment getCommentById(int id);
	public List<Comment> getCommentsByUserOrName(Integer userId, String name);
	
}
