package com.albummanager.service;
import java.util.List;

import com.albummanager.model.Photo;

public interface IPhotoService {
	
	public List<Photo> getAllPhotos();
	public Photo getPhotoById(int id);
	public List<Photo> getPhotosByUserId(int userId);
}
