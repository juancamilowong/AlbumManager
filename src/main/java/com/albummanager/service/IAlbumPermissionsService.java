package com.albummanager.service;

import java.util.List;

import com.albummanager.model.User;

public interface IAlbumPermissionsService {
	
	public void saveAlbumPermissions(int userId, int albumId, int permission) throws Exception;
	public void updateAlbumPermissions(int userId, int albumId, int permission);
	
	public List<User> getUsersByAlbumFilteredByPermission(int albumId, int permission);
}
