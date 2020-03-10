package com.albummanager.service;
import java.util.List;

import com.albummanager.model.User;

public interface IUserService {
	
	public List<User> getAllUsers();
	public User getUser(int id) throws Exception ;
	
	public User saveUser(User user);
	public User getUserOfRepository(int id);
	
	public List<User> getUsersByAlbumFilteredByPermission(int albumId, int permission);
}
