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
	// ���id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	// �����
	@Column(length = 255, nullable = false)
	private String title;
	// ���ؼ���
	@Column(length = 255, nullable = false)
	private String keyword;
	// ������ʱ��
	@Temporal(value = TemporalType.DATE)
	private String date;
	// ͼƬ�鿴����
	@Column()
	private long times;
	// �����ͼ���������û�
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	// �����ͼ����������Ŀ
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "channel_id", nullable = false)
	private Channel channel;
	// ����µ�ͼƬ�б�
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