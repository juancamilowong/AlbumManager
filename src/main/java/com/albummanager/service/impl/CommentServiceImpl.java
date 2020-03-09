package com.albummanager.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.albummanager.commons.Constants;
import com.albummanager.model.Comment;
import com.albummanager.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Comment> getAllcomments() {
		List<Comment> comments = Arrays.asList(restTemplate.getForObject(Constants.URL_SERVICE + "comments", Comment[].class));
		return comments;
	}

	@Override
	public Comment getCommentById(int id) {
		Map<String, String> pathVars = new HashMap<String, String>();
		pathVars.put("id", Integer.toString(id));
		Comment comment = restTemplate.getForObject(Constants.URL_SERVICE + "comments/{id}", Comment.class, pathVars);
		return comment;
	}

	@Override
	public List<Comment> getCommentsByUserAndName() {
		// TODO Auto-generated method stub
		return null;
	}

}
