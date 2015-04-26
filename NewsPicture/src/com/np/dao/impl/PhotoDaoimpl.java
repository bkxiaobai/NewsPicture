package com.np.dao.impl;

import java.util.List;

import com.np.dao.PhotoDao;
import com.np.hql.NHibernateDaoSupport;
import com.np.po.Photo;

public class PhotoDaoimpl extends NHibernateDaoSupport implements PhotoDao {
	/**
	 * ���ݱ�ʶ����������Photoʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Photoʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Photoʵ��
	 */
	@Override
	public Photo findById(Integer id) {
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
	public List<Photo> findByUser(int user_id, int pageNo) {
		int offset = (pageNo - 1) * PAGE_SIZE;
		// ���ط�ҳ��ѯ�Ľ��
		return (List<Photo>) findByPage("from photo where user_id = ?",
				user_id, offset, PAGE_SIZE);
	}

	@SuppressWarnings("unchecked")
	public List<Photo> findByAlbum(int album_id, int pageNo) {
		int offset = (pageNo - 1) * PAGE_SIZE;
		return (List<Photo>) findByPage("from photo where album_id = ?",
				album_id, offset, PAGE_SIZE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> findByTitle(String title, int pageNo) {
		// @SuppressWarnings("unchecked")
		int offset = (pageNo - 1) * PAGE_SIZE;
		return (List<Photo>) findByPage("from photo where title like ?",
				'%' + title + '%',offset,PAGE_SIZE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> findByKeyword(String keyword,int pageNo) {
		int offset = (pageNo - 1) * PAGE_SIZE;
		return(List<Photo>) findByPage("from photo where keyword like ?",
				'%' + keyword + '%',offset,PAGE_SIZE);
	}
}