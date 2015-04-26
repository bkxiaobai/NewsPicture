package com.np.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.np.dao.AlbumDao;
import com.np.dao.PhotoDao;
import com.np.hql.NHibernateDaoSupport;
import com.np.po.Album;
import com.np.po.Photo;

public class AlbumDaoimpl extends NHibernateDaoSupport implements
		AlbumDao {
	/**
	 * ���ݱ�ʶ����������Albumʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Albumʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Albumʵ��
	 */
	@Autowired
	PhotoDao photoDao;
	
	@Override
	public Album findById(Integer id) {
		return getHibernateTemplate().get(Album.class, id);
	}

	/**
	 * �־û�ָ����Albumʵ��
	 * 
	 * @param album
	 *            ��Ҫ���־û���Albumʵ��
	 * @return Albumʵ�����־û���ı�ʶ����ֵ
	 */
	@Override
	public Integer save(Album album) {
		return (Integer) getHibernateTemplate().save(album);
	}

	/**
	 * �޸�ָ����Albumʵ��
	 * 
	 * @param album
	 *            ��Ҫ���޸ĵ�Albumʵ��
	 */
	@Override
	public void update(Album album) {
		getHibernateTemplate().update(album);
	}

	/**
	 * ɾ��ָ����Albumʵ��
	 * 
	 * @param album
	 *            ��Ҫ��ɾ����Albumʵ��
	 */
	@Override
	public void delete(Album album) {
		List<Photo> photos = photoDao.findByAlbum(album.getId(),8);
		for (Photo photo : photos) {
			Assert.assertNotNull(photo);
			photoDao.delete(photo);
		}
		getHibernateTemplate().delete(album);

	}

	/**
	 * ��ѯȫ����Albumʵ��
	 * 
	 * @return ���ݿ���ȫ����Albumʵ��
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Album> findAll() {
		return (List<Album>) getHibernateTemplate().find("from album");
	}

	/**
	 * ��ѯ����ָ���û���ͼ�����ҽ��з�ҳ����
	 * 
	 * @param user
	 *            ��ѯͼ���������û�
	 * @param pageNo
	 *            ��Ҫ��ѯ��ָ��ҳ
	 * @return ��ѯ����ͼ��
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Album> findByUser(int user_id, int pageNo) {
		int offset = (pageNo - 1) * PAGE_SIZE;
		// ���ط�ҳ��ѯ�Ľ��
		return (List<Album>) findByPage("from album  where user_id = ?", user_id,
				offset, PAGE_SIZE);
}
	
	@SuppressWarnings("unchecked")
	public List<Album> findByChannel(int channel_id, int pageNo) {
		int offset = (pageNo - 1) * PAGE_SIZE;
		return (List<Album>) findByPage("from album where channel_id = ?",channel_id,
				offset,PAGE_SIZE);
	}
	
}

