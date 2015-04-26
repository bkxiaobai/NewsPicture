package com.np.dao.impl;

import java.util.List;

import com.np.dao.PhotoDao;
import com.np.hql.NHibernateDaoSupport;
import com.np.po.Photo;

public class PhotoDaoimpl extends NHibernateDaoSupport implements PhotoDao {
	/**
	 * 根据标识属性来加载Photo实例
	 * 
	 * @param id
	 *            需要加载的Photo实例的标识属性值
	 * @return 指定标识属性对应的Photo实例
	 */
	@Override
	public Photo findById(Integer id) {
		return getHibernateTemplate().get(Photo.class, id);
	}

	/**
	 * 持久化指定的Photo实例
	 * 
	 * @param photo
	 *            需要被持久化的Photo实例
	 * @return Photo实例被持久化后的标识属性值
	 */
	@Override
	public Integer save(Photo photo) {
		return (Integer) getHibernateTemplate().save(photo);
	}

	/**
	 * 修改指定的Photo实例
	 * 
	 * @param photo
	 *            需要被修改的Photo实例
	 */
	@Override
	public void update(Photo photo) {
		getHibernateTemplate().update(photo);
	}

	/**
	 * 删除指定的Photo实例
	 * 
	 * @param photo
	 *            需要被删除的Photo实例
	 */
	@Override
	public void delete(Photo photo) {
		getHibernateTemplate().delete(photo);
	}

	/**
	 * 查询全部的Photo实例
	 * 
	 * @return 数据库中全部的Photo实例
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Photo> findAll() {
		return (List<Photo>) getHibernateTemplate().find("from photo");
	}

	/**
	 * 查询属于指定用户的相片，且进行分页控制
	 * 
	 * @param user
	 *            查询相片所属的用户
	 * @param pageNo
	 *            需要查询的指定页
	 * @return 查询到的相片
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Photo> findByUser(int user_id, int pageNo) {
		int offset = (pageNo - 1) * PAGE_SIZE;
		// 返回分页查询的结果
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