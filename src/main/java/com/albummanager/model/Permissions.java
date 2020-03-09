package com.albummanager.model;

import java.util.HashMap;
import java.util.Map;

public enum Permissions {
	N(0),
	R(1),
	W(2),
	RW(3);
	
	private static final Map<Integer, Permissions> BY_VALUE = new HashMap<>();
	
	static {
		for(Permissions p : values()) {
			BY_VALUE.put(p.id, p);
		}
	}
	
	private Integer id;
	
	private Permissions(Integer id) {
		this.id = id;
	}
	
	public static Permissions getPermission(Integer permission) {
		return BY_VALUE.get(permission);
	}
}
