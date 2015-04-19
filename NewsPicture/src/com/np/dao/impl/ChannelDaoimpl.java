package com.np.dao.impl;

import com.np.dao.ChannelDao;
import com.np.hql.NHibernateDaoSupport;
import com.np.po.Channel;

public class ChannelDaoimpl extends NHibernateDaoSupport implements
     ChannelDao {
	/**
	 * ���ݱ�ʶ����������Channelʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Channelʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Channelʵ��
	 */
	public Channel get(Integer id) {
		return (Channel) getHibernateTemplate().get(Channel.class, id);
	}

	/**
	 * �־û�ָ����Channelʵ��
	 * 
	 * @param Channel
	 *            ��Ҫ���־û���Channelʵ��
	 * @return Channelʵ�����־û���ı�ʶ����ֵ
	 */
	public Integer save(Channel channel) {
		return (Integer) getHibernateTemplate().save(channel);
	}

	/**
	 * �޸�ָ����Channelʵ��
	 * 
	 * @param Channel
	 *            ��Ҫ���޸ĵ�Channelʵ��
	 */
	public void update(Channel channel) {
		getHibernateTemplate().update(channel);
	}

	/**
	 * ɾ��ָ����Channelʵ��
	 * 
	 * @param Channel
	 *            ��Ҫ��ɾ����Channelʵ��
	 */
	public void delete(Channel channel) {
		getHibernateTemplate().delete(channel);
	}

	/**
	 * ���ݱ�ʶ����ɾ��Channelʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����Channelʵ���ı�ʶ����ֵ
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}
}
