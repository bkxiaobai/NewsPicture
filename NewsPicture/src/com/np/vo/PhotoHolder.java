package com.np.vo;

public class PhotoHolder {
	// 相片的名称
	private String title;
	// 相片在服务器上的文件名
	private String fileName;
	//关键词
	private String keyword;

	// 无参数的构造器
	public PhotoHolder() {
	}

	// 初始化全部属性的构造器
	public PhotoHolder(String title, String fileName, String keyword) {
		this.title = title;
		this.fileName = fileName;
		this.keyword = keyword;
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
}
