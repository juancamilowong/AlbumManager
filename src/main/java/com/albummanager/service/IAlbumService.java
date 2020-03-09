package com.albummanager.service;

import java.util.List;

import com.albummanager.model.Album;

public interface IAlbumService {

	public List<Album> getAllAlbums();

	public Album getAlbumById(int id);

	public List<Album> getAlbumsByUser(int userId);
}
