package com.np.dao;

import java.util.List;

import com.np.po.Photo;

//PhotoDao接口, test
public interface PhotoDao {
	// 以常量控制每页显示的相片数
	final int PAGE_SIZE = 8;

	// 根据id加载photo实例
	Photo findById(Integer id);

	// 持久化photo实例
	Integer save(Photo photo);

	// 修改指定的photo实例
	void update(Photo photo);

	// 删除指定的photo实例
	void delete(Photo photo);

	// 查询全部的photo实例
	List<Photo> findAll();

	// 查询属于指定图集的相片，分页控制album:查询相片所属图集，
	List<Photo> findByAlbum(int album_id, int pageNo);

	// 查询属于指定用户的相片，且进行分页控制，user:查询相片所属的用户,pageNo需要查询的指定页,return查询到的相片
	List<Photo> findByUser(int user_id, int pageNo);

	// 根据相片名称查找
	List<Photo> findByTitle(String title, int pageNo);

	// 根据相片关键词查找
	List<Photo> findByKeyword(String keyword, int pageNo);

}
