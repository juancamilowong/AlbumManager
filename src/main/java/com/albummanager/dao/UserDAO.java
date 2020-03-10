package com.albummanager.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.albummanager.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
	
	@Query(value ="select u.*" + 
			"  from album_permissions ap" + 
			"  join user u" + 
			"    on u.id = ap.user_id" + 
			" where ap.album_id = :album_id" + 
			"   and ap.permissions = :permission_value "
			,nativeQuery=true)
	List<User> findByAlbumAndAPermission(@Param("album_id") Integer album_id, @Param("permission_value") Integer permission_value);
}
