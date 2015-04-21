package com.np.dao.impl;

import java.util.List;

import com.np.dao.PhotoDao;
import com.np.hql.NHibernateDaoSupport;
import com.np.po.Photo;
import com.np.po.User;

public class PhotoDaoimpl extends NHibernateDaoSupport implements
		PhotoDao {
	/**
	 * ���ݱ�ʶ����������Photoʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Photoʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Photoʵ��
	 */
	@Override
	public Photo get(Integer id) {
		return getHibernateTemplate().get(Photo.class, id);
	}

	/**
	 * �־û�ָ����Photoʵ��
	 * 
	 * @param photo
	 *            ��Ҫ���־û���Photoʵ��
	 * @return Photoʵ�����־û���ı�ʶ����ֵ
	 */
	@Override
	public Integer save(Photo photo) {
		return (Integer) getHibernateTemplate().save(photo);
	}

	/**
	 * �޸�ָ����Photoʵ��
	 * 
	 * @param photo
	 *            ��Ҫ���޸ĵ�Photoʵ��
	 */
	@Override
	public void update(Photo photo) {
		getHibernateTemplate().update(photo);
	}

	/**
	 * ɾ��ָ����Photoʵ��
	 * 
	 * @param photo
	 *            ��Ҫ��ɾ����Photoʵ��
	 */
	@Override
	public void delete(Photo photo) {
		getHibernateTemplate().delete(photo);
	}


	/**
	 * ��ѯȫ����Photoʵ��
	 * 
	 * @return ���ݿ���ȫ����Photoʵ��
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Photo> findAll() {
		return (List<Photo>) getHibernateTemplate().find("from photo");
	}

	/**
	 * ��ѯ����ָ���û�����Ƭ���ҽ��з�ҳ����
	 * 
	 * @param user
	 *            ��ѯ��Ƭ�������û�
	 * @param pageNo
	 *            ��Ҫ��ѯ��ָ��ҳ
	 * @return ��ѯ������Ƭ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Photo> findByUser(User user, int pageNo) {
		int offset = (pageNo - 1) * PAGE_SIZE;
		// ���ط�ҳ��ѯ�Ľ��
		return (List<Photo>) findByPage("from photo p where p.user = ?", user,
				offset, PAGE_SIZE);
	}

	@SuppressWarnings("unchecked")
	public List<Photo> findByAlbum(int album_id) {
		return (List<Photo>) getHibernateTemplate().find("from photo where album_id = ?",album_id);
	}
	
	@Override
	public Photo findByTitle(String title) {
		@SuppressWarnings("unchecked")
		List<Photo> photos = (List<Photo>) getHibernateTemplate().find(
				"from photo p where p.title = ?", title);
		if (photos != null && photos.size() == 1) {
			return photos.get(0);
		}
		return null;
	}
	
	@Override
	public List<Photo> findByKeyword(String keyword) {
		@SuppressWarnings("unchecked")
		List<Photo> photos = (List<Photo>) getHibernateTemplate().find(
				"from photo p where p.keyword like ?", '%' + keyword + '%');
			return photos;
	}
}