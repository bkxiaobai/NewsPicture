package com.np.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

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

	public User findByNameAndPass(String username, String password) {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getHibernateTemplate().find(
				"from user as u where u.username = ? and u.password = ?",
				username, password);
		return users.size() == 0 ? null : users.get(0);
	}

	public User findByName(String username) {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getHibernateTemplate().find(
				"from user u where u.username = ?", username);
		return users.size() == 0 ? null : users.get(0);
	}
}