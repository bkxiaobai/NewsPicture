package com.np.dao.impl;

import java.util.List;
import com.np.dao.AlbumDao;
import com.np.hql.NHibernateDaoSupport;
import com.np.po.Album;
import com.np.po.User;

public class AlbumDaoimpl extends NHibernateDaoSupport implements
		AlbumDao {
	/**
	 * ���ݱ�ʶ����������Albumʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Albumʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Albumʵ��
	 */
	public Album get(Integer id) {
		return (Album) getHibernateTemplate().get(Album.class, id);
	}

	/**
	 * �־û�ָ����Albumʵ��
	 * 
	 * @param album
	 *            ��Ҫ���־û���Albumʵ��
	 * @return Albumʵ�����־û���ı�ʶ����ֵ
	 */
	public Integer save(Album album) {
		return (Integer) getHibernateTemplate().save(album);
	}

	/**
	 * �޸�ָ����Albumʵ��
	 * 
	 * @param album
	 *            ��Ҫ���޸ĵ�Albumʵ��
	 */
	public void update(Album album) {
		getHibernateTemplate().update(album);
	}

	/**
	 * ɾ��ָ����Albumʵ��
	 * 
	 * @param album
	 *            ��Ҫ��ɾ����Albumʵ��
	 */
	public void delete(Album album) {
		getHibernateTemplate().delete(album);
	}

	/**
	 * ���ݱ�ʶ����ɾ��Albumʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����Albumʵ���ı�ʶ����ֵ
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ��ѯȫ����Albumʵ��
	 * 
	 * @return ���ݿ���ȫ����Albumʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Album> findAll() {
		return (List<Album>) getHibernateTemplate().find("from Album");
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
	@SuppressWarnings("unchecked")
	public List<Album> findByUser(User user, int pageNo) {
		int offset = (pageNo - 1) * PAGE_SIZE;
		// ���ط�ҳ��ѯ�Ľ��
		return (List<Album>) findByPage("from Album b where b.user = ?", user,
				offset, PAGE_SIZE);
	}
}
