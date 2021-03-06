package com.np.po;

import java.io.Serializable;
import java.util.Date;

//标准注解
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "photo")
public class Photo implements Serializable {

	private static final long serialVersionUID = 1L;
	// 图片id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	// 该图片的名称
	@Column(length = 255, nullable = false)
	private String title;
	// 该图片的关键词属性
	@Column(length = 255, nullable = false)
	private String keyword;
	// 图片查看次数
	@Column()
	private long times;
	// 图片绝对地址
	@Column(length = 255, nullable = false)
	private String picUrl;
	// 大图保存路径
	@Column(length = 255, nullable = false)
	private String bigPicUrl;
	// 缩略图保存路径
	@Column(length = 255, nullable = false)
	private String smallPicUrl;
	// 添加图片时间
	@Temporal(value = TemporalType.DATE)
	private Date date;
	// 是否为封面
	@Column()
	private boolean cover;
	// 保存该图片所属的图集
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id", nullable = false)
	private Album album;

	public Photo(String title, String keyword, long times, String picUrl,
			String bigPicUrl, String smallPicUrl, Date date, boolean cover,
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
