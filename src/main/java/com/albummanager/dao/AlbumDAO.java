package com.albummanager.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.albummanager.model.Album;

@Repository
public interface AlbumDAO extends CrudRepository<Album, Integer> {

}
