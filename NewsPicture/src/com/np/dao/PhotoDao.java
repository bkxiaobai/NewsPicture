package com.np.dao;

import java.util.List;

import com.np.po.Album;

import com.np.po.Photo;

//PhotoDao�ӿ�, test
public interface PhotoDao {
	// ����id����photoʵ��
	Photo get(Integer id);

	// ����photo
	void save(Photo photo);

	// ����photo
	void update(Photo photo);

	// ����idɾ��photo
	void delete(int id);

	// ɾ��ָ����photo
	void delete(Photo photo);

	/**
	 * ��ȡָ�����ķ�����ƬID��
	 * 
	 * @param al
	 *            ָ����ᡣ
	 * @flag ��Ƭ�Ƿ�Ϊ���������ꡣ
	 * @return ָ�����ķ���ID��
	 */
	Integer getCover(Album al, boolean flag);

	/**
	 * ��ȡָ������ָ��ҳ����Ƭ�б�
	 * 
	 * @param al
	 *            ָ������ᡣ
	 * @param first
	 *            ָ�������Ҫ��ʾ�ĵ�һ����Ƭ
	 * @param pageSize
	 *            ÿҳ��ʾ����Ƭ����
	 * @return �ض�ҳ����ʾ����Ƭ�б�
	 */
	List<Photo> getPhotos(final Album al, final int first, final int pageSize);

	/**
	 * ��ʾ�������������
	 * 
	 * @param ָ�������
	 * @return �������������
	 */
	int getCount(Album al);

	/**
	 * ��ȡָ�����ķ�����Ƭ��
	 * 
	 * @param al
	 *            ָ����ᡣ
	 * @flag ��Ƭ�Ƿ�Ϊ���������ꡣ
	 * @return ָ�����ķ��档
	 */
	Photo getCoverPhoto(Album al, boolean flag);
}
