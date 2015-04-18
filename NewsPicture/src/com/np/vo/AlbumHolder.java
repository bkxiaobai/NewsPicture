package com.np.vo;

public class AlbumHolder {
	// 图集的名称
	private String title;
	
	// 无参数的构造器
	public AlbumHolder() {
	}

	// 初始化全部属性的构造器
	public AlbumHolder(String title) {
		this.title = title;
	}

	// title属性的setter和getter方法
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}
}
