package com.np.po;

import java.io.Serializable;

public class Photo implements Serializable {

	private static final long serialVersionUID = 1L;
	// ͼƬid
	private int id;
	// ��ͼƬ������
	private String title;
	// ��ͼƬ�Ĺؼ�������
	private String keyword;
	// ͼƬ�鿴����
	private long times;
	// ͼƬ���Ե�ַ
	private String picUrl;
	// ��ͼ����·��
	private String bigPicUrl;
	// ����ͼ����·��
	private String smallPicUrl;
	// ���ͼƬʱ��
	private String date;
	// �Ƿ�Ϊ����
	private boolean cover;
	// �����ͼƬ������ͼ��
	private Album album;

	// �޲����Ĺ�����
	public Photo(String title, String keyword, long times, String picUrl,
			String bigPicUrl, String smallPicUrl, String date, boolean cover,
			Album album) {
		setTitle(title);
		setKeyword(keyword);
		setTimes(times);
		setPicUrl(picUrl);
		setBigPicUrl(bigPicUrl);
		setSmallPicUrl(smallPicUrl);
		setDate(date);
		setAlbum(album);
		setCover(cover);
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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Photo() {
	}
}
