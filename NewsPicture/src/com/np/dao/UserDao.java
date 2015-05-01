package com.np.dao;

import com.np.po.User;

//UserDao接口
public interface UserDao {

	// 根据id加载用户实例
	User get(Integer id);

	// 保存用户
	void save(User user);

	// 跟新用户
	void update(User user);

	// 根据id删除用户
	void delete(int id);

	// 删除指定用户
	void delete(User user);

	//根据用户名密码查找用户
	Integer findByNameAndPass(String username, String password);
	
	// 根据用户名查找用户
	Integer findByName(String name);
}
