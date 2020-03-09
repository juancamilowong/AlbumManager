package com.albummanager.model;

public class RequestPermissions {
	
	private int userId;
	private int albumId;
	private int permissionValue;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public int getPermissionValue() {
		return permissionValue;
	}
	public void setPermissionValue(int permissionValue) {
		this.permissionValue = permissionValue;
	}
	
	
}
