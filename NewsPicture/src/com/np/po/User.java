package com.np.po;

import java.util.Set;
import java.util.HashSet;


public class User {
	// 用户ID
	private Integer id;
	// 用户名
	private String username;
	// 用户密码
	private String password;
	// 使用Set保存该用户关联的相片
	private Set<Photo> photos = new HashSet<Photo>();
	// 使用Set保存该用户关联的图集
	private Set<Album> albums = new HashSet<Album>();

	// 无参数的构造器
	public User() {
	}

	// 初始化全部属性的构造器
	public User(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	// id属性的setter和getter方法
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// name属性的setter和getter方法
	public void setName(String username) {
		this.username = username;
	}

	public String getName() {
		return this.username;
	}

	// pass属性的setter和getter方法
	public void setPass(String password) {
		this.password = password;
	}

	public String getPass() {
		return this.password;
	}

	// photos属性的setter和getter方法
	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	public Set<Photo> getPhotos() {
		return this.photos;
	}
	// albums属性的setter和getter方法
	public Set<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

}
