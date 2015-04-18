package com.np.po;

import java.util.Set;
import java.util.HashSet;


public class Column {
	// 栏目ID
	private Integer id;
	// 栏目名
	private String title;
	// 使用Set保存该栏目关联的图集
	private Set<Album> albums = new HashSet<Album>();

	// 无参数的构造器
	public Column() {
	}

	// 初始化全部属性的构造器
	public Column(Integer id, String title) {
		this.id = id;
		this.title = title;
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
	
	// albums属性的setter和getter方法
	public Set<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}
}