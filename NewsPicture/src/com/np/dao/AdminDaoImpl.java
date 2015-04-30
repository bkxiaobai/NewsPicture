package com.np.dao;

import com.np.dao.AdminDao;
import com.np.po.Admin;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {
	public Admin get(Integer id) {
		return (Admin) getHibernateTemplate().get(Admin.class, id);
	}

	public void save(Admin admin) {
		getHibernateTemplate().save(admin);
	}

	public void update(Admin admin) {
		getHibernateTemplate().update(admin);
	}

	public void delete(int id) {
		getHibernateTemplate().delete(
				getHibernateTemplate().get(Admin.class, new Integer(id)));
	}

	public void delete(Admin admin) {
		getHibernateTemplate().delete(admin);
	}

	public Admin findByNameAndPass(String name, String pass) {
		Admin admin = (Admin) getHibernateTemplate().find(
				"from admin as a where a.name = ? and a.pass = ?", name,
				pass);
		return admin;
	}

}
