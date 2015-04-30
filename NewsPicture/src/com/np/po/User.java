package com.np.po;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	// 用户ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	// 用户名
	@Column(length = 255, unique = true, nullable = false)
	private String username;
	// 用户密码
	@Column(length = 255, nullable = false)
	private String password;
	// 用户相册列表,级联操作
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Album> albums = new HashSet<Album>();

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
