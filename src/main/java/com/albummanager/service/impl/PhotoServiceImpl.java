package com.albummanager.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.albummanager.commons.Constants;
import com.albummanager.model.Album;
import com.albummanager.model.Photo;
import com.albummanager.service.IPhotoService;

@Service
public class PhotoServiceImpl implements IPhotoService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Photo> getAllPhotos() {
		List<Photo> photos = Arrays.asList(restTemplate.getForObject(Constants.URL_SERVICE + "photos", Photo[].class));
		return photos;
	}

	@Override
	public List<Photo> getPhotosByUserId(int userId) {
		List<Album> albums = Arrays.asList(restTemplate.getForObject(Constants.URL_SERVICE + "albums?userId="+userId, Album[].class));
		List<Photo> photos = new ArrayList<Photo>();
		albums.forEach(a -> {
			photos.addAll(getPhotosByAlbum(a.getId()));
		});
		return photos;
	}

	@Override
	public Photo getPhotoById(int id) {
		Map<String, String> pathVars = new HashMap<String, String>();
		pathVars.put("id", Integer.toString(id));
		Photo photo = restTemplate.getForObject(Constants.URL_SERVICE + "photos/{id}", Photo.class, pathVars);
		return photo;
	}
	
	public List<Photo> getPhotosByAlbum(int albumId){
		List<Photo> photos = Arrays.asList(restTemplate.getForObject(Constants.URL_SERVICE+"photos?albumId="+albumId, Photo[].class));
		return photos;
	}

}
