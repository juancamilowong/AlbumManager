package com.albummanager.service;
import java.util.List;
import java.util.Optional;

import com.albummanager.model.User;

public interface IUserService {
	
	public List<User> getAllUsers();
	public Optional<User> getUser(int id) throws Exception ;
	public Optional<User> getUserByUserName(String name);
	public User saveUser(User user);
	public User getUserOfRepository(int id);
	
	public List<User> getUsersByAlbumFilteredByPermission(int albumId, int permission);
}
