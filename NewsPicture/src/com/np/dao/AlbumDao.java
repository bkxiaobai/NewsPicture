package com.np.dao;

import java.util.List;

import com.np.po.Album;
import com.np.po.User;


//AlbumDao接口
public interface AlbumDao {
	// 以常量控制每页显示的图集数
	final int PAGE_SIZE = 8;

	//根据id加载album实例
	Album findById(Integer id);

	//持久化album实例
	Integer save(Album album);

	//修改指定的album实例
	void update(Album album);

	//删除指定的album实例
	void delete(Album album);

	//查询全部的album实例
	List<Album> findAll();

   //查询属于指定用户的图集，且进行分页控制，user:查询图集所属的用户,pageNo需要查询的指定页,return查询到的图集
	List<Album> findByUser(User user, int pageNo);
	
	List<Album> findByChannel(int channel_id);
}
