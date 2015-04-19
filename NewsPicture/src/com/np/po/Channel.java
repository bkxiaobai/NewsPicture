package com.np.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "channel")
public class Channel {
	// ��ĿID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	// ��Ŀ��
	@Column(length = 255, nullable = false)
	private String title;

	// �޲����Ĺ�����
	public Channel() {
	}

	// ��ʼ��ȫ�����ԵĹ�����
	public Channel(Integer id, String title) {
		this.id = id;
		this.title = title;
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

}