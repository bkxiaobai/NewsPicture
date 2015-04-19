package com.np.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.np.po.User;
import com.np.po.Channel;

@Entity(name="album")
public class Album {
	// 图集ID
    @Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer id;
	// 图集名称
    @Column(length=255, nullable=false)  
	private String title;
	// 保存该图集所属的用户
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	// 保存该图集所属的栏目
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "channel_id", nullable = false)
	private Channel channel;

	// 无参数的构造器
	public Album() {
	}

	// 初始化全部属性的构造器
	public Album(Integer id, String title, User user,Channel channel) {
		this.id = id;
		this.title = title;
		this.user = user;
		this.channel = channel;
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

	// user属性的setter和getter方法
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

	// column属性的setter和getter方法
	public Channel getChannel() {
		return this.channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}