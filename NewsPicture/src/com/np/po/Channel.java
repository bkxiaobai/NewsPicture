package com.np.po;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class Channel implements Serializable {

	private static final long serialVersionUID = 1L;
	// 栏目ID
	private Integer id;
	// 栏目名
	private String title;
	// 栏目下的图集列表
	private Set<Album> albums = new HashSet<Album>();

	// 无参数的构造器
	public Channel() {
	}

	// 初始化全部属性的构造器
	public Channel(String title) {
		setTitle(title);
	}

	// id属性的setter和getter方法
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// title属性的setter和getter方法
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

}