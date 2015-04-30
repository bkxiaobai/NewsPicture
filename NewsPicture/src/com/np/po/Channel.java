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

@Entity(name = "channel")
public class Channel implements Serializable {

	private static final long serialVersionUID = 1L;
	// 栏目ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	// 栏目名
	@Column(length = 255, unique = true, nullable = false)
	private String title;
	// 栏目下的图集列表
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "channel")
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