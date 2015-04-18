package com.np.dao;

import java.util.List;
import com.np.po.Photo;
import com.np.po.User;


//PhotoDao接口, test
public interface PhotoDao {
	// 以常量控制每页显示的相片数
	final int PAGE_SIZE = 8;

	//根据id加载photo实例
	Photo get(Integer id);

	//持久化photo实例
	Integer save(Photo photo);

	//修改指定的photo实例
	void update(Photo photo);

	//删除指定的photo实例
	void delete(Photo photo);

	//根据id删除photo实例
	void delete(Integer id);

	//查询全部的photo实例
	List<Photo> findAll();

   //查询属于指定用户的相片，且进行分页控制，user:查询相片所属的用户,pageNo需要查询的指定页,return查询到的相片
	List<Photo> findByUser(User user, int pageNo);
}

