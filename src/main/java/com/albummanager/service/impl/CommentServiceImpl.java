package com.albummanager.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.albummanager.commons.Constants;
import com.albummanager.exception.RestTemplateErrorHandler;
import com.albummanager.model.Comment;
import com.albummanager.model.Post;
import com.albummanager.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {
	
	@Override
	public List<Comment> getAllcomments() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RestTemplateErrorHandler());
		List<Comment> comments = Arrays.asList(restTemplate.getForObject(Constants.URL_SERVICE + "comments", Comment[].class));
		return comments;
	}

	@Override
	public Comment getCommentById(int id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RestTemplateErrorHandler());
		Map<String, String> pathVars = new HashMap<String, String>();
		pathVars.put("id", Integer.toString(id));
		Comment comment = restTemplate.getForObject(Constants.URL_SERVICE + "comments/{id}", Comment.class, pathVars);
		return comment;
	}

	@Override
	public List<Comment> getCommentsByUserOrName(Integer userId, String name) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RestTemplateErrorHandler());
		List<Comment> comments = new ArrayList<Comment>();
		
		if(userId == null && name == null) {
			comments = getAllcomments();
			return comments;
		}		
		if(userId != null) {
			List<Post> posts = Arrays.asList(restTemplate.getForObject(Constants.URL_SERVICE + "posts?userId="+userId, Post[].class));
			List<Comment> commentsByUser = new ArrayList<Comment>();
			posts.forEach(p -> {
				List<Comment> commentsByPost = Arrays.asList(restTemplate.getForObject(Constants.URL_SERVICE + "comments?postId="+p.getId(), Comment[].class));
				commentsByUser.addAll(commentsByPost);
			});
			
			comments = commentsByUser;
		}else {
			if(name != null && !name.equals("")) {
				comments = Arrays.asList(restTemplate.getForObject(Constants.URL_SERVICE + "comments?name="+name, Comment[].class));
			}
		}
		return comments;
	}

}
