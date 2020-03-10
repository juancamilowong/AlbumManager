package com.albummanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.albummanager.dao.AlbumDAO;
import com.albummanager.dao.AlbumPermissionsDAO;
import com.albummanager.dao.UserDAO;
import com.albummanager.model.Album;
import com.albummanager.model.AlbumPermissions;
import com.albummanager.model.Permissions;
import com.albummanager.model.User;
import com.albummanager.service.IAlbumPermissionsService;
import com.albummanager.service.IAlbumService;
import com.albummanager.service.IUserService;

@Service
public class AlbumPermissionsServiceImpl implements IAlbumPermissionsService {

	@Autowired
	UserDAO userDao;

	@Autowired
	AlbumDAO albumDao;

	@Autowired
	AlbumPermissionsDAO albumPermissionsDao;

	@Autowired
	IAlbumService albumService;
	
	@Autowired
	IUserService userService;

	@Transactional
	@Override
	public void saveAlbumPermissions(int userId, int albumId, int permissionValue) throws Exception {
		Permissions permission = Permissions.getPermission(permissionValue);
		Album album;
		User user;
		if (!permission.equals(Permissions.N)) {
			if (!isUserPresent(userId)) {
				user = userService.getUser(userId);
				if (user != null) {
					userDao.save(user);
				} else {
					throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
				}

			} else {
				user = userDao.findById(userId).get();
			}
			
			if (!isAlbumPresent(albumId)) {
				album = albumService.getAlbumById(albumId);
				if (album != null) {
					album = albumDao.save(album);
				} else {
					throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
				}

			} else {
				album = albumDao.findById(albumId).get();
			}
			
			if (!isAlbumPermissionPresent(userId, albumId)) {
				AlbumPermissions albumPermission = new AlbumPermissions(permission,user,album);
				albumPermissionsDao.save(albumPermission);
			}
		}
	}

	@Override
	public void updateAlbumPermissions(int userId, int albumId, int permissionValue) {
		AlbumPermissions albumPermissions = albumPermissionsDao.findByUserIdAndAlbumId(userId, albumId);
		if(albumPermissions != null) {
			Permissions permission = Permissions.getPermission(permissionValue);
			if(!permission.equals(Permissions.N)) {
				albumPermissions.setPermissions(permission);
				albumPermissionsDao.save(albumPermissions);
			}else {
				albumPermissionsDao.delete(albumPermissions);
			}
		}
				
	}

	public boolean isAlbumPermissionPresent(Integer userId, Integer albumId) {

		return albumPermissionsDao.findByUserIdAndAlbumId(userId, albumId) != null ? true : false;

	}

	public boolean isAlbumPresent(Integer albumId) {

		return albumDao.findById(albumId).isPresent();

	}

	public boolean isUserPresent(Integer userId) {
		return userDao.findById(userId).isPresent();
	}

	@Override
	public List<User> getUsersByAlbumFilteredByPermission(int albumId, int permission) {
		return userService.getUsersByAlbumFilteredByPermission(albumId, permission);
	}

}
