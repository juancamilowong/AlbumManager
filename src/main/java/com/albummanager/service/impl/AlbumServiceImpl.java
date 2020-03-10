package com.albummanager.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.albummanager.commons.Constants;
import com.albummanager.exception.RestTemplateErrorHandler;
import com.albummanager.model.Album;
import com.albummanager.service.IAlbumService;

@Service
public class AlbumServiceImpl implements IAlbumService {

	@Override
	public List<Album> getAllAlbums() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RestTemplateErrorHandler());
		List<Album> albums= Arrays.asList(restTemplate.getForObject(Constants.URL_SERVICE + "albums", Album[].class));
		return albums;
	}

	@Override
	public List<Album> getAlbumsByUser(int userId) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RestTemplateErrorHandler());
		List<Album> albums= Arrays.asList(restTemplate.getForObject(Constants.URL_SERVICE + "albums?userId="+userId, Album[].class));
		return albums;
	}

	@Override
	public Album getAlbumById(int id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RestTemplateErrorHandler());
		Map<String, String> pathVars = new HashMap<String, String>();
		pathVars.put("id", Integer.toString(id));
		Album album = restTemplate.getForObject(Constants.URL_SERVICE + "albums/{id}", Album.class, pathVars);
		return album;
	}


}
