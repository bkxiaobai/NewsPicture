package com.np.vo;

public class AlbumHolder {
	// ͼ��������
	private String title;
	
	// �޲����Ĺ�����
	public AlbumHolder() {
	}

	// ��ʼ��ȫ�����ԵĹ�����
	public AlbumHolder(String title) {
		this.title = title;
	}

	// title���Ե�setter��getter����
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}
}
