package com.np.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "channel")
public class Channel {
	// 栏目ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	// 栏目名
	@Column(length = 255, nullable = false)
	private String title;

	// 无参数的构造器
	public Channel() {
	}

	// 初始化全部属性的构造器
	public Channel(Integer id, String title) {
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

}