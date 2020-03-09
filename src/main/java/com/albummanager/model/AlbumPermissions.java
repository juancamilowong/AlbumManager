package com.albummanager.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "album_permissions")
public class AlbumPermissions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated
	private Permissions permissions;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "album_id", nullable = false)
	private Album album;
	
	public AlbumPermissions() {
	}

	public AlbumPermissions(Permissions permissions, User user, Album album) {
		super();
		this.permissions = permissions;
		this.user = user;
		this.album = album;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Permissions getPermissions() {
		return permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
}
