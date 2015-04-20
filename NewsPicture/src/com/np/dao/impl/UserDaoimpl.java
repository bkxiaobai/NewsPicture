package com.np.dao.impl;

import java.util.List;

import com.np.dao.UserDao;
import com.np.hql.NHibernateDaoSupport;
import com.np.po.User;

public class UserDaoimpl extends NHibernateDaoSupport implements
		UserDao {
	/**
	 * 根据标识属性来加载User实例
	 * 
	 * @param id
	 *            需要加载的User实例的标识属性值
	 * @return 指定标识属性对应的User实例
	 */
	@Override
	public User get(Integer id) {
		return getHibernateTemplate().get(User.class, id);
	}

	/**
	 * 持久化指定的User实例
	 * 
	 * @param user
	 *            需要被持久化的User实例
	 * @return User实例被持久化后的标识属性值
	 */
	@Override
	public Integer save(User user) {
		return (Integer) getHibernateTemplate().save(user);
	}

	/**
	 * 修改指定的User实例
	 * 
	 * @param user
	 *            需要被修改的User实例
	 */
	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	/**
	 * 删除指定的User实例
	 * 
	 * @param user
	 *            需要被删除的User实例
	 */
	@Override
	public void delete(User user) {
		getHibernateTemplate().delete(user);
	}

	/**
	 * 根据标识属性删除User实例
	 * 
	 * @param id
	 *            需要被删除的User实例的标识属性值
	 */
	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * 查询全部的User实例
	 * 
	 * @return 数据库中全部的User实例
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return (List<User>) getHibernateTemplate().find("from user");
	}

	/**
	 * 根据用户名查找用户
	 * 
	 * @param name
	 *            需要查找的用户的用户名
	 * @return 查找到的用户
	 */
	@Override
	@SuppressWarnings("unchecked")
	public User findByName(String username) {
		List<User> users = (List<User>) getHibernateTemplate().find(
				"from user u where u.username = ?", username);
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}
}
