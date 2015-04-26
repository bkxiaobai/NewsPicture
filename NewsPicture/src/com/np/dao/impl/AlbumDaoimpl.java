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
	 * 根据标识属性来加载Album实例
	 * 
	 * @param id
	 *            需要加载的Album实例的标识属性值
	 * @return 指定标识属性对应的Album实例
	 */
	@Autowired
	PhotoDao photoDao;
	
	@Override
	public Album findById(Integer id) {
		return getHibernateTemplate().get(Album.class, id);
	}

	/**
	 * 持久化指定的Album实例
	 * 
	 * @param album
	 *            需要被持久化的Album实例
	 * @return Album实例被持久化后的标识属性值
	 */
	@Override
	public Integer save(Album album) {
		return (Integer) getHibernateTemplate().save(album);
	}

	/**
	 * 修改指定的Album实例
	 * 
	 * @param album
	 *            需要被修改的Album实例
	 */
	@Override
	public void update(Album album) {
		getHibernateTemplate().update(album);
	}

	/**
	 * 删除指定的Album实例
	 * 
	 * @param album
	 *            需要被删除的Album实例
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
	 * 查询全部的Album实例
	 * 
	 * @return 数据库中全部的Album实例
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Album> findAll() {
		return (List<Album>) getHibernateTemplate().find("from album");
	}

	/**
	 * 查询属于指定用户的图集，且进行分页控制
	 * 
	 * @param user
	 *            查询图集所属的用户
	 * @param pageNo
	 *            需要查询的指定页
	 * @return 查询到的图集
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Album> findByUser(int user_id, int pageNo) {
		int offset = (pageNo - 1) * PAGE_SIZE;
		// 返回分页查询的结果
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

