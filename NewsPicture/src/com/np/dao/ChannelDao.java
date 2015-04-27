package com.np.dao;

import java.util.List;

import com.np.po.Channel;

//ChannelDao接口
public interface ChannelDao {

	// 根据标识属性来加载栏目,需要加载栏目的id,指定id对应的栏目
	Channel findById(Integer id);

	// 持久化栏目
	Integer save(Channel channel);

	// 修改栏目
	void update(Channel channel);

	// 删除指定栏目
	void delete(Channel channel);

	// 查找所有栏目
	List<Channel> findAll();
	
	Channel findByTitle(String title);
	
}
