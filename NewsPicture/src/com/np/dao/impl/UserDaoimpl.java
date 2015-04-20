package com.np.dao.impl;

import java.util.List;

import com.np.dao.UserDao;
import com.np.hql.NHibernateDaoSupport;
import com.np.po.User;

public class UserDaoimpl extends NHibernateDaoSupport implements
		UserDao {
	/**
	 * ���ݱ�ʶ����������Userʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Userʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Userʵ��
	 */
	@Override
	public User get(Integer id) {
		return getHibernateTemplate().get(User.class, id);
	}

	/**
	 * �־û�ָ����Userʵ��
	 * 
	 * @param user
	 *            ��Ҫ���־û���Userʵ��
	 * @return Userʵ�����־û���ı�ʶ����ֵ
	 */
	@Override
	public Integer save(User user) {
		return (Integer) getHibernateTemplate().save(user);
	}

	/**
	 * �޸�ָ����Userʵ��
	 * 
	 * @param user
	 *            ��Ҫ���޸ĵ�Userʵ��
	 */
	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	/**
	 * ɾ��ָ����Userʵ��
	 * 
	 * @param user
	 *            ��Ҫ��ɾ����Userʵ��
	 */
	@Override
	public void delete(User user) {
		getHibernateTemplate().delete(user);
	}

	/**
	 * ���ݱ�ʶ����ɾ��Userʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����Userʵ���ı�ʶ����ֵ
	 */
	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ��ѯȫ����Userʵ��
	 * 
	 * @return ���ݿ���ȫ����Userʵ��
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return (List<User>) getHibernateTemplate().find("from user");
	}

	/**
	 * �����û��������û�
	 * 
	 * @param name
	 *            ��Ҫ���ҵ��û����û���
	 * @return ���ҵ����û�
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
