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
	 * ���ݱ�ʶ����������Channelʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Channelʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Channelʵ��
	 */
	@Override
	public Channel get(Integer id) {
		return getHibernateTemplate().get(Channel.class, id);
	}

	/**
	 * �־û�ָ����Channelʵ��
	 * 
	 * @param Channel
	 *            ��Ҫ���־û���Channelʵ��
	 * @return Channelʵ�����־û���ı�ʶ����ֵ
	 */
	@Override
	public Integer save(Channel channel) {
		return (Integer) getHibernateTemplate().save(channel);
	}

	/**
	 * �޸�ָ����Channelʵ��
	 * 
	 * @param Channel
	 *            ��Ҫ���޸ĵ�Channelʵ��
	 */
	@Override
	public void update(Channel channel) {
		getHibernateTemplate().update(channel);
	}

	/**
	 * ɾ��ָ����Channelʵ��
	 * 
	 * @param Channel
	 *            ��Ҫ��ɾ����Channelʵ��
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
	 * ���ݱ�ʶ����ɾ��Channelʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����Channelʵ���ı�ʶ����ֵ
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
