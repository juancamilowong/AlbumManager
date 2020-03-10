package com.albummanager.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.albummanager.commons.Constants;
import com.albummanager.dao.UserDAO;
import com.albummanager.exception.RestTemplateErrorHandler;
import com.albummanager.model.User;
import com.albummanager.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired(required = true)
	private UserDAO userDao;
	
	@Override
	public List<User> getAllUsers() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RestTemplateErrorHandler());
		
		List<User> users = Arrays.asList(restTemplate.getForObject(Constants.URL_SERVICE + "users", User[].class));
		return users;
	}

	@Override
	public User getUser(int id) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RestTemplateErrorHandler());
		Map<String, String> pathVars = new HashMap<String, String>();
		pathVars.put("id", Integer.toString(id));
		User user = restTemplate.getForObject(Constants.URL_SERVICE + "users/{id}", User.class, pathVars);
		return user.getId() != null ? user : null;
	}

	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User getUserOfRepository(int id) {
		return userDao.findById(id).get();
	}

	@Override
	public List<User> getUsersByAlbumFilteredByPermission(int albumId, int permissionValue) {

		return userDao.findByAlbumAndAPermission(albumId, permissionValue);
	}

	
}
