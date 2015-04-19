package com.np.dao.impl;

import com.np.dao.ChannelDao;
import com.np.hql.NHibernateDaoSupport;
import com.np.po.Channel;

public class ChannelDaoimpl extends NHibernateDaoSupport implements
     ChannelDao {
	/**
	 * 根据标识属性来加载Channel实例
	 * 
	 * @param id
	 *            需要加载的Channel实例的标识属性值
	 * @return 指定标识属性对应的Channel实例
	 */
	public Channel get(Integer id) {
		return (Channel) getHibernateTemplate().get(Channel.class, id);
	}

	/**
	 * 持久化指定的Channel实例
	 * 
	 * @param Channel
	 *            需要被持久化的Channel实例
	 * @return Channel实例被持久化后的标识属性值
	 */
	public Integer save(Channel channel) {
		return (Integer) getHibernateTemplate().save(channel);
	}

	/**
	 * 修改指定的Channel实例
	 * 
	 * @param Channel
	 *            需要被修改的Channel实例
	 */
	public void update(Channel channel) {
		getHibernateTemplate().update(channel);
	}

	/**
	 * 删除指定的Channel实例
	 * 
	 * @param Channel
	 *            需要被删除的Channel实例
	 */
	public void delete(Channel channel) {
		getHibernateTemplate().delete(channel);
	}

	/**
	 * 根据标识属性删除Channel实例
	 * 
	 * @param id
	 *            需要被删除的Channel实例的标识属性值
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}
}
