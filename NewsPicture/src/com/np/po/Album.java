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
	// ͼ��ID
    @Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer id;
	// ͼ������
    @Column(length=255, nullable=false)  
	private String title;
	// �����ͼ���������û�
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	// �����ͼ����������Ŀ
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "channel_id", nullable = false)
	private Channel channel;

	// �޲����Ĺ�����
	public Album() {
	}

	// ��ʼ��ȫ�����ԵĹ�����
	public Album(Integer id, String title, User user,Channel channel) {
		this.id = id;
		this.title = title;
		this.user = user;
		this.channel = channel;
	}

	// id���Ե�setter��getter����
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// title���Ե�setter��getter����
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	// user���Ե�setter��getter����
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

	// column���Ե�setter��getter����
	public Channel getChannel() {
		return this.channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}