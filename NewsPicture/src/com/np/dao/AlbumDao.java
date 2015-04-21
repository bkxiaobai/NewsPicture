package com.np.dao;

import java.util.List;

import com.np.po.Album;
import com.np.po.User;


//AlbumDao�ӿ�
public interface AlbumDao {
	// �Գ�������ÿҳ��ʾ��ͼ����
	final int PAGE_SIZE = 8;

	//����id����albumʵ��
	Album findById(Integer id);

	//�־û�albumʵ��
	Integer save(Album album);

	//�޸�ָ����albumʵ��
	void update(Album album);

	//ɾ��ָ����albumʵ��
	void delete(Album album);

	//��ѯȫ����albumʵ��
	List<Album> findAll();

   //��ѯ����ָ���û���ͼ�����ҽ��з�ҳ���ƣ�user:��ѯͼ���������û�,pageNo��Ҫ��ѯ��ָ��ҳ,return��ѯ����ͼ��
	List<Album> findByUser(User user, int pageNo);
	
	List<Album> findByChannel(int channel_id);
}
