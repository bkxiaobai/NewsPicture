package com.np.po;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	// 用户ID
	private Integer id;
	// 用户名
	private String username;
	// 用户密码
	private String password;
	// 用户相册列表,级联操作
	private Set<Album> albums = new HashSet<Album>();

	// 无参数的构造器
	public User() {
	}

	public User(String username, String password) {
		setUsername(username);
		setPassword(password);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

}
