package com.albummanager.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.albummanager.model.AlbumPermissions;

@Repository
public interface AlbumPermissionsDAO extends CrudRepository<AlbumPermissions, Integer>{
	
	public AlbumPermissions findByUserIdAndAlbumId(Integer userId, Integer albumId);
}
