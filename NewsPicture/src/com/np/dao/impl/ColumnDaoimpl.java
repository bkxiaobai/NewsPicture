package com.np.dao.impl;

import com.np.dao.ColumnDao;
import com.np.hql.NHibernateDaoSupport;
import com.np.po.Column;

public class ColumnDaoimpl extends NHibernateDaoSupport implements
     ColumnDao {
	/**
	 * ���ݱ�ʶ����������Columnʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Columnʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Columnʵ��
	 */
	public Column get(Integer cid) {
		return (Column) getHibernateTemplate().get(Column.class, cid);
	}

	/**
	 * �־û�ָ����Columnʵ��
	 * 
	 * @param column
	 *            ��Ҫ���־û���Columnʵ��
	 * @return Columnʵ�����־û���ı�ʶ����ֵ
	 */
	public Integer save(Column column) {
		return (Integer) getHibernateTemplate().save(column);
	}

	/**
	 * �޸�ָ����Columnʵ��
	 * 
	 * @param column
	 *            ��Ҫ���޸ĵ�Columnʵ��
	 */
	public void update(Column column) {
		getHibernateTemplate().update(column);
	}

	/**
	 * ɾ��ָ����Columnʵ��
	 * 
	 * @param column
	 *            ��Ҫ��ɾ����Columnʵ��
	 */
	public void delete(Column column) {
		getHibernateTemplate().delete(column);
	}

	/**
	 * ���ݱ�ʶ����ɾ��Columnʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����Columnʵ���ı�ʶ����ֵ
	 */
	public void delete(Integer cid) {
		getHibernateTemplate().delete(get(cid));
	}
}
