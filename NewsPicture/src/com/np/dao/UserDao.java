package com.np.dao;


import java.util.List;
import com.np.po.User;

//UserDao接口
public interface UserDao {
	
//根据标识属性来加载用户,需要加载用户的id,指定id对应的用户	 
	User get(Integer id);

//持久化用户
	Integer save(User user);

//修改用户
	void update(User user);

//删除指定用户
	void delete(User user);

//根据id删除用户
	void delete(Integer id);

//查询全部用户
	List<User> findAll();

//根据用户名查找用户
	User findByName(String username);
}
