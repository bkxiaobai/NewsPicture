package com.np.po;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class Channel implements Serializable {

	private static final long serialVersionUID = 1L;
	// ��ĿID
	private Integer id;
	// ��Ŀ��
	private String title;
	// ��Ŀ�µ�ͼ���б�
	private Set<Album> albums = new HashSet<Album>();

	// �޲����Ĺ�����
	public Channel() {
	}

	// ��ʼ��ȫ�����ԵĹ�����
	public Channel(String title) {
		setTitle(title);
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

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

}