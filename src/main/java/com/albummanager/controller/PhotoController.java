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

import com.albummanager.model.Photo;
import com.albummanager.service.IPhotoService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
@RequestMapping(value = { "/api/photos" })
public class PhotoController {
	
	@Autowired
	private IPhotoService photoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Photo> getAllPhotos() {
		List<Photo> list = photoService.getAllPhotos();
		return list;
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getPhoto(@PathVariable int id) {
		
		Photo photo = null;
		try {
			photo = photoService.getPhotoById(id);
			
		} catch (Exception e) {
			if (e.getMessage().contains("404 Not Found")) {
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(photo);		
	}
	
	@GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Photo> getPhotoByUserId(@PathVariable int id) {		
		List<Photo> list = photoService.getPhotosByUserId(id);
		return list;	
	}
}
