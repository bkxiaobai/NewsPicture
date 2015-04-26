package com.np.dao;

import java.util.List;

import com.np.po.Photo;

//PhotoDao�ӿ�, test
public interface PhotoDao {
	// �Գ�������ÿҳ��ʾ����Ƭ��
	final int PAGE_SIZE = 8;

	// ����id����photoʵ��
	Photo findById(Integer id);

	// �־û�photoʵ��
	Integer save(Photo photo);

	// �޸�ָ����photoʵ��
	void update(Photo photo);

	// ɾ��ָ����photoʵ��
	void delete(Photo photo);

	// ��ѯȫ����photoʵ��
	List<Photo> findAll();

	// ��ѯ����ָ��ͼ������Ƭ����ҳ����album:��ѯ��Ƭ����ͼ����
	List<Photo> findByAlbum(int album_id, int pageNo);

	// ��ѯ����ָ���û�����Ƭ���ҽ��з�ҳ���ƣ�user:��ѯ��Ƭ�������û�,pageNo��Ҫ��ѯ��ָ��ҳ,return��ѯ������Ƭ
	List<Photo> findByUser(int user_id, int pageNo);

	// ������Ƭ���Ʋ���
	List<Photo> findByTitle(String title, int pageNo);

	// ������Ƭ�ؼ��ʲ���
	List<Photo> findByKeyword(String keyword, int pageNo);

}
