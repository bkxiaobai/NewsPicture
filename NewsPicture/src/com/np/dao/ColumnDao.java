package com.np.dao;

import com.np.po.Column;

//ColumnDao接口
public interface ColumnDao {

	// 根据标识属性来加载栏目,需要加载栏目的id,指定id对应的栏目
	Column get(Integer cid);

	// 持久化栏目
	Integer save(Column column);

	// 修改栏目
	void update(Column column);

	// 删除指定栏目
	void delete(Column column);

	// 根据id删除栏目
	void delete(Integer cid);

}
