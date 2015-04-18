package com.np.dao.impl;

import com.np.dao.ColumnDao;
import com.np.hql.NHibernateDaoSupport;
import com.np.po.Column;

public class ColumnDaoimpl extends NHibernateDaoSupport implements
     ColumnDao {
	/**
	 * 根据标识属性来加载Column实例
	 * 
	 * @param id
	 *            需要加载的Column实例的标识属性值
	 * @return 指定标识属性对应的Column实例
	 */
	public Column get(Integer cid) {
		return (Column) getHibernateTemplate().get(Column.class, cid);
	}

	/**
	 * 持久化指定的Column实例
	 * 
	 * @param column
	 *            需要被持久化的Column实例
	 * @return Column实例被持久化后的标识属性值
	 */
	public Integer save(Column column) {
		return (Integer) getHibernateTemplate().save(column);
	}

	/**
	 * 修改指定的Column实例
	 * 
	 * @param column
	 *            需要被修改的Column实例
	 */
	public void update(Column column) {
		getHibernateTemplate().update(column);
	}

	/**
	 * 删除指定的Column实例
	 * 
	 * @param column
	 *            需要被删除的Column实例
	 */
	public void delete(Column column) {
		getHibernateTemplate().delete(column);
	}

	/**
	 * 根据标识属性删除Column实例
	 * 
	 * @param id
	 *            需要被删除的Column实例的标识属性值
	 */
	public void delete(Integer cid) {
		getHibernateTemplate().delete(get(cid));
	}
}
