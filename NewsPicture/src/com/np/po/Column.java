package com.np.po;

import java.util.Set;
import java.util.HashSet;


public class Column {
	// ��ĿID
	private Integer cid;
	// ��Ŀ��
	private String title;
	// ʹ��Set�������Ŀ������ͼ��
	private Set<Album> albums = new HashSet<Album>();

	// �޲����Ĺ�����
	public Column() {
	}

	// ��ʼ��ȫ�����ԵĹ�����
	public Column(Integer cid, String title) {
		this.cid = cid;
		this.title = title;
	}

	// id���Ե�setter��getter����
	public void setId(Integer cid) {
		this.cid = cid;
	}

	public Integer getId() {
		return this.cid;
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