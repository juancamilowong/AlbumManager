package com.albummanager.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.albummanager.model.Comment;
import com.albummanager.service.ICommentService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
@RequestMapping(value = { "/api/comments" })
public class CommentController {
	
	@Autowired
	private ICommentService commentService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Comment> getAllComments() {
		List<Comment> list = commentService.getAllcomments();
		return list;
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getComment(@PathVariable int id) {
		
		Comment comment = null;
		try {
			comment = commentService.getCommentById(id);
			 
		} catch (Exception e) {
			if (e.getMessage().contains("404 Not Found")) {
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(comment);		
	}
	
	@GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Comment> getCommentsByUserOrName(@Valid @PathParam("userId") Integer userId, 
			@PathParam("name") String name) {
		
		List<Comment> list = commentService.getCommentsByUserOrName(userId, name);
		return list;	
	}
}
