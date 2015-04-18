package com.np.po;

import com.np.po.User;
import com.np.po.Album;

public class Photo {
	// 图片ID
	private Integer pid;
	// 该图片的名称
	private String title;
	// 图片在服务器上的文件名
	private String fileName;
	// 该图片的关键词属性
	private String keyword;
	// 保存该图片所属的用户
	private User user;
	// 保存该图片所属的图集
	private Album album;

	// 无参数的构造器
	public Photo() {
	}

	// 初始化全部属性的构造器
	public Photo(Integer pid, String title, String fileName,String keyword, User user,Album album) {
		this.pid = pid;
		this.title = title;
		this.fileName = fileName;
		this.keyword = keyword;
		this.user = user;
		this.album =album;
	}

	// id属性的setter和getter方法
	public void setId(Integer pid) {
		this.pid = pid;
	}

	public Integer getId() {
		return this.pid;
	}

	// title属性的setter和getter方法
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	// fileName属性的setter和getter方法
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

	// keyword属性的setter和getter方法
	public String getKeyword() {
		return this.keyword;
		}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
		}
	
	// user属性的setter和getter方法
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

	// album属性的setter和getter方法
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
}