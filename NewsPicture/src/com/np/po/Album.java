package com.np.po;

import com.np.po.User;
import com.np.po.Channel;

public class Album {
	// ͼ��ID
	private Integer id;
	// ͼ������
	private String title;
	// �����ͼ���������û�
	private User user;
	// �����ͼ����������Ŀ
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