package com.np.vo;

public class PhotoHolder {
	// ��Ƭ������
	private String title;
	// ��Ƭ�ڷ������ϵ��ļ���
	private String fileName;
	//�ؼ���
	private String keyword;

	// �޲����Ĺ�����
	public PhotoHolder() {
	}

	// ��ʼ��ȫ�����ԵĹ�����
	public PhotoHolder(String title, String fileName, String keyword) {
		this.title = title;
		this.fileName = fileName;
		this.keyword = keyword;
	}

	// title���Ե�setter��getter����
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	// fileName���Ե�setter��getter����
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

	// keyword���Ե�setter��getter����
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
