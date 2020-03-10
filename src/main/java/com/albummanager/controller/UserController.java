package com.albummanager.controller;

import java.util.List;

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

import com.albummanager.model.User;
import com.albummanager.service.IUserService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
@RequestMapping(value = { "/api/users" })
public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		List<User> list = userService.getAllUsers();
		return list;
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUser(@PathVariable int id) {

		User user = null;
		try {
			user = userService.getUser(id);

		} catch (Exception e) {
			if (e.getMessage().contains("404 Not Found")) {
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
}
