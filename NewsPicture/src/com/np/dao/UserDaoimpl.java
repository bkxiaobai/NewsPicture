package com.np.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.np.po.User;

public class UserDaoimpl extends HibernateDaoSupport implements UserDao {

	public User get(Integer id) {
		return (User) getHibernateTemplate().get(User.class, id);
	}

	public void save(User user) {
		getHibernateTemplate().save(user);
	}

	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	public void delete(User user) {
		getHibernateTemplate().delete(user);
	}

	public void delete(int id) {
		getHibernateTemplate().delete(
				getHibernateTemplate().get(User.class, new Integer(id)));
	}

	public Integer findByNameAndPass(String username, String password) {
		String[] args = { username, password };
		List<?> result = getHibernateTemplate().find(
				"from User as u where u.username = ? and u.password = ?", args);
		if (result.size() == 1) {
			User u = (User) result.get(0);
			return new Integer(u.getId());
		}
		return null;
	}

	public Integer findByName(String username) {
		String[] args = { username };
		List<?> result = getHibernateTemplate().find(
				"from User as u where u.username = ?", args);
		if (result.size() == 1) {
			User u = (User) result.get(0);
			return new Integer(u.getId());
		}
		return null;
	}
}