package com.np.dao;

import com.np.po.User;

//UserDao�ӿ�
public interface UserDao {

	// ����id�����û�ʵ��
	User get(Integer id);

	// �����û�
	void save(User user);

	// �����û�
	void update(User user);

	// ����idɾ���û�
	void delete(int id);

	// ɾ��ָ���û�
	void delete(User user);

	//�����û�����������û�
	Integer findByNameAndPass(String username, String password);
	
	// �����û��������û�
	Integer findByName(String name);
}
