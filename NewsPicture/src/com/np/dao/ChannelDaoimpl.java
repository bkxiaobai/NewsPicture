package com.np.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import com.np.po.Album;
import com.np.po.Channel;

public class ChannelDaoimpl extends HibernateDaoSupport implements ChannelDao {

	public Channel get(Integer id) {
		return (Channel) getHibernateTemplate().get(Channel.class, id);
	}

	public void save(Channel channel) {
		getHibernateTemplate().save(channel);
	}

	public void update(Channel channel) {
		getHibernateTemplate().update(channel);
	}
	
	public void delete(int id) {
		getHibernateTemplate().delete(
				getHibernateTemplate().get(Channel.class, new Integer(id)));
	}

	public void delete(Channel channel) {
		getHibernateTemplate().delete(channel);
	}

	public List<Album> getAllByChannel(final Channel channel, final int first,
			final int pageSize) {
		@SuppressWarnings("unchecked")
		List<Album> result = (List<Album>) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(Session session) {
						List<?> tmp = session
								.createQuery(
										"from album as al where al.channel = :channel")
								.setEntity("channel", channel)
								.setFirstResult(first).setMaxResults(pageSize)
								.list();
						return tmp;
					}
				});
		return result;
	}

	public int getAmount(Channel channel) {
		Object[] args = { channel };
		List<?> result = getHibernateTemplate().find(
				"from album as al where al.channel = ?", args);
		return result.size();
	}

	@SuppressWarnings("unchecked")
	public List<Channel> getAll() {
		return (List<Channel>) getHibernateTemplate().find("from channel");
	}

}
