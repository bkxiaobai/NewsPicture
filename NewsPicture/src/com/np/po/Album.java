package com.np.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.np.po.Channel;
import com.np.po.User;
import java.io.Serializable;

@Entity(name = "album")
public class Album implements Serializable {

	private static final long serialVersionUID = 1L;
	// 相册id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	// 相册名
	@Column(length = 255, nullable = false)
	private String title;
	// 相册关键词
	@Column(length = 255, nullable = false)
	private String keyword;
	// 添加相册时间
	@Temporal(value = TemporalType.DATE)
	private String date;
	// 图片查看次数
	@Column()
	private long times;
	// 保存该图集所属的用户
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	// 保存该图集所属的栏目
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "channel_id", nullable = false)
	private Channel channel;
	// 相册下的图片列表
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "album")
	private Set<Photo> photos = new HashSet<Photo>();

	public Album() {
	}

	public Album(String title, String keyword, String date, long times,
			User user, Channel channel) {
		setTitle(title);
		setKeyword(keyword);
		setDate(date);
		setTimes(times);
		setUser(user);
		setChannel(channel);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getTimes() {
		return times;
	}

	public void setTimes(long times) {
		this.times = times;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}