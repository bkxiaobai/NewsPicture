package com.np.po;

import java.util.Set;
import java.util.HashSet;


public class Column {
	// ��ĿID
	private Integer id;
	// ��Ŀ��
	private String title;
	// ʹ��Set�������Ŀ������ͼ��
	private Set<Album> albums = new HashSet<Album>();

	// �޲����Ĺ�����
	public Column() {
	}

	// ��ʼ��ȫ�����ԵĹ�����
	public Column(Integer id, String title) {
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
	
	// albums���Ե�setter��getter����
	public Set<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}
}