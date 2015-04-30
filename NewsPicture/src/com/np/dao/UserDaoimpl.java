package com.np.dao;

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
		User user = (User) getHibernateTemplate().find(
				"from user as u where u.username = ? and u.password = ?",
				username, password);
		return user;
	}

	public User findByName(String username) {
		User user = (User) getHibernateTemplate().find(
				"from user u where u.username = ?", username);
		return user;
	}
}