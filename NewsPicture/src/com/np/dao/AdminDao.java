package com.np.dao;

import com.np.po.Admin;

public interface AdminDao
{
	/**
	 * �����������ع���Ա��
	 * @param id ��Ҫ���صĹ���ԱID��
	 * @return ��������Ӧ�Ĺ���Ա��
	 */
	Admin get(Integer id);

	/**
	 * �����ض��Ĺ���Աʵ�塣
	 * @param admin ��Ҫ����Ĺ���Ա��
	 */
	void save(Admin admin);

	/**
	 * �޸��ض����������ʵ��
	 * @param admin ��Ҫ�޸ĵĹ���Ա
	 */
	void update(Admin admin);

	/**
	 * ��������ɾ������Ա
	 * @param id ��Ҫɾ���Ĺ���ԱID��
	 */
	void delete(int id);

	/**
	 * ɾ��ָ���Ĺ���Ա��
	 * @param admin ��Ҫɾ���Ĺ���Ա
	 */
	void delete(Admin admin);

	/**
	 * ���ݹ���Ա���������ѯ����Ա��
	 * @param name ��Ҫ��ѯ����Ա�Ĺ���Ա����
	 * @param pass ��Ҫ��ѯ����Ա�����롣
	 * @return ָ������Ա���������Ӧ����Ա������ֵ��
	 */
	Integer findByNameAndPass(String name, String pass);
}
