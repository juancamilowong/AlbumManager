package com.albummanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.albummanager.model.RequestPermissions;
import com.albummanager.model.User;
import com.albummanager.service.IAlbumPermissionsService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
@RequestMapping(value = { "/api/permissions" })
public class AlbumPermissionsController {
	
	@Autowired
	IAlbumPermissionsService albumpermissionsService;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void addPermissions(@RequestBody RequestPermissions request) {
		try {
			albumpermissionsService.saveAlbumPermissions(request.getUserId(), 
					request.getAlbumId(), request.getPermissionValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public void updatePermissions(@RequestBody RequestPermissions request) {
		try {
			albumpermissionsService.updateAlbumPermissions(request.getUserId(), 
					request.getAlbumId(), request.getPermissionValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
	@GetMapping("/user/album/{album_id}/permission/{permission_value}")
	public List<User> getAllUsers(@PathVariable("album_id") int albumId, 
			@PathVariable("permission_value") int permission) {
		List<User> list = albumpermissionsService.getUsersByAlbumFilteredByPermission(albumId, permission);
		return list;
	}
	
	
}
