package com.np.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.np.dao.AlbumDao;
import com.np.dao.ChannelDao;
import com.np.hql.NHibernateDaoSupport;
import com.np.po.Album;
import com.np.po.Channel;


public class ChannelDaoimpl extends NHibernateDaoSupport implements
     ChannelDao {
	
	@Autowired
	AlbumDao albumDao;
	/**
	 * 根据标识属性来加载Channel实例
	 * 
	 * @param id
	 *            需要加载的Channel实例的标识属性值
	 * @return 指定标识属性对应的Channel实例
	 */
	@Override
	public Channel get(Integer id) {
		return getHibernateTemplate().get(Channel.class, id);
	}

	/**
	 * 持久化指定的Channel实例
	 * 
	 * @param Channel
	 *            需要被持久化的Channel实例
	 * @return Channel实例被持久化后的标识属性值
	 */
	@Override
	public Integer save(Channel channel) {
		return (Integer) getHibernateTemplate().save(channel);
	}

	/**
	 * 修改指定的Channel实例
	 * 
	 * @param Channel
	 *            需要被修改的Channel实例
	 */
	@Override
	public void update(Channel channel) {
		getHibernateTemplate().update(channel);
	}

	/**
	 * 删除指定的Channel实例
	 * 
	 * @param Channel
	 *            需要被删除的Channel实例
	 */
	@Override
	public void delete(Channel channel) {
		List<Album> albums = albumDao.findByChannel(channel.getId());
		for (Album album: albums) {
			albumDao.delete(album);
		}
		getHibernateTemplate().delete(channel);
	}

	/**
	 * 根据标识属性删除Channel实例
	 * 
	 * @param id
	 *            需要被删除的Channel实例的标识属性值
	 */
	@Override
	public void delete(Integer id) {
		delete(get(id));
	}
	
	@SuppressWarnings("unchecked")
	public Channel findByTitle(String title) {
		List<Channel> channels = (List<Channel>) getHibernateTemplate().find(
				"from channel  where title = ?", title);
		if (channels != null && channels.size() == 1) {
			return channels.get(0);
		}
		return null;
	}
}
