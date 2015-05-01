package com.np.po;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	// �û�ID
	private Integer id;
	// �û���
	private String username;
	// �û�����
	private String password;
	// �û�����б�,��������
	private Set<Album> albums = new HashSet<Album>();

	// �޲����Ĺ�����
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
