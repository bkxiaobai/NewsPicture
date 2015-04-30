package com.np.po;

import java.io.Serializable;
//��׼ע��
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "photo")
public class Photo implements Serializable {

	private static final long serialVersionUID = 1L;
	// ͼƬid
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	// ��ͼƬ������
	@Column(length = 255, nullable = false)
	private String title;
	// ��ͼƬ�Ĺؼ�������
	@Column(length = 255, nullable = false)
	private String keyword;
	// ͼƬ�鿴����
	@Column()
	private long times;
	// ͼƬ���Ե�ַ
	@Column(length = 255, nullable = false)
	private String picUrl;
	// ��ͼ����·��
	@Column(length = 255, nullable = false)
	private String bigPicUrl;
	// ����ͼ����·��
	@Column(length = 255, nullable = false)
	private String smallPicUrl;
	// ���ͼƬʱ��
	@Temporal(value = TemporalType.DATE)
	private String date;
	// �Ƿ�Ϊ����
	@Column()
	private boolean cover;
	// �����ͼƬ������ͼ��
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id", nullable = false)
	private Album album;

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
