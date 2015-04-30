package com.np.vo;

import java.io.Serializable;

public class AlbumVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String keyword;
	private String date;
	private long times;
	private int userId;
	private String user;
	private int channelId;
	private String channelTitle;
	private int coverId;
	private String coverUrl;

	public AlbumVO() {
	}

	public AlbumVO(int id, String title, String keyword, String date,
			long times, int userId, String user, int channelId,
			String channeltitle, int coverId, String coverUrl) {
		setId(id);
		setTitle(title);
		setKeyword(keyword);
		setDate(date);
		setTimes(times);
		setUserId(userId);
		setUser(user);
		setChannelId(channelId);
		setChannelTitle(channelTitle);
		setCoverId(coverId);
		setCoverUrl(coverUrl);
	}

	public AlbumVO(int id, String title, String keyword, String date,
			long times, int userId, String user, int channelId,
			String channelTitle) {
		setId(id);
		setTitle(title);
		setKeyword(keyword);
		setDate(date);
		setTimes(times);
		setUserId(userId);
		setUser(user);
		setChannelId(channelId);
		setChannelTitle(channelTitle);
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getChannelTitle() {
		return channelTitle;
	}

	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}

	public int getCoverId() {
		return coverId;
	}

	public void setCoverId(int coverId) {
		this.coverId = coverId;
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
