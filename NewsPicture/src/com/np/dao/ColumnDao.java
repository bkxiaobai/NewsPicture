package com.np.dao;

import com.np.po.Column;

//ColumnDao�ӿ�
public interface ColumnDao {

	// ���ݱ�ʶ������������Ŀ,��Ҫ������Ŀ��id,ָ��id��Ӧ����Ŀ
	Column get(Integer cid);

	// �־û���Ŀ
	Integer save(Column column);

	// �޸���Ŀ
	void update(Column column);

	// ɾ��ָ����Ŀ
	void delete(Column column);

	// ����idɾ����Ŀ
	void delete(Integer cid);

}
