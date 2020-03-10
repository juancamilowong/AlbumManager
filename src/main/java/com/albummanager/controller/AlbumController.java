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

import com.albummanager.exception.ErrorResponse;
import com.albummanager.model.Album;
import com.albummanager.service.IAlbumService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
@RequestMapping(value = { "/api/albums" })
public class AlbumController {
	
	@Autowired
	private IAlbumService albumService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Album> getAllAlbums() {
		List<Album> list = albumService.getAllAlbums();
		return list;
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAlbum(@PathVariable int id) {
		
		Album album = null;
		try {
			album = albumService.getAlbumById(id);
			
		} catch (Exception e) {
			if(e.getMessage().contains("404 Not Found")) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Object not found"));
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(album);		
	}
}
