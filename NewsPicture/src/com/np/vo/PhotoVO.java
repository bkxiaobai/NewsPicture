package com.np.vo;
import java.io.Serializable;

public class PhotoVO implements Serializable
{

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String keyword;
	private long times;
	private String picUrl;
	private String bigPicUrl;
	private String smallPicUrl;
	private String date;
	private boolean cover;
	private int albumId;
	private String albumTitle;

	public PhotoVO()
	{
	}

	public PhotoVO(int id, String title, String keyword, long times, String picUrl, String bigPicUrl, 
		String smallPicUrl, String date, boolean cover, int albumId, String albumTitle)
	{
		setId(id);
		setTitle(title);
		setKeyword(keyword);
		setTimes(times);
		setPicUrl(picUrl);
		setBigPicUrl(bigPicUrl);
		setSmallPicUrl(smallPicUrl);
		setDate(date);
		setCover(cover);
		setAlbumId(albumId);
		setAlbumTitle(albumTitle);
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public long getTimes() {
		return times;
	}

	public void setTimes(long times) {
		this.times = times;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getBigPicUrl() {
		return bigPicUrl;
	}

	public void setBigPicUrl(String bigPicUrl) {
		this.bigPicUrl = bigPicUrl;
	}

	public String getSmallPicUrl() {
		return smallPicUrl;
	}

	public void setSmallPicUrl(String smallPicUrl) {
		this.smallPicUrl = smallPicUrl;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isCover() {
		return cover;
	}

	public void setCover(boolean cover) {
		this.cover = cover;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	
}
