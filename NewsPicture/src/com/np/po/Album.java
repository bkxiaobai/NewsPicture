package com.np.po;

import java.util.HashSet;
import java.util.Set;

import com.np.po.Channel;
import com.np.po.User;

import java.io.Serializable;

public class Album implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String date;
	private long times;
	private User user;
	private Channel channel;
	private Set<Photo> photos = new HashSet<Photo>();

	public Album() {
	}

	public Album(String title, String date, long times, User user,
			Channel channel) {
		setTitle(title);
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
}