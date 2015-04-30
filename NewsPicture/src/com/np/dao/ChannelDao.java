package com.np.dao;

import java.util.List;

import com.np.po.Album;
import com.np.po.Channel;

//ChannelDao接口
public interface ChannelDao {
	// 根据表示属性加载
	Channel get(Integer id);

	// 持久化栏目
	void save(Channel channel);

	// 修改栏目
	void update(Channel channel);

	// 删除指定栏目
	void delete(Channel channel);
    
	//id删除
	void delete(int id);
	
	//查询所有栏目
	List<Channel> getAll();
	
	// 得到栏目内所有相册
	List<Album> getAllByChannel(final Channel channel, final int first,
			final int pageSize);

	// 获取栏目的相册数量
	int getAmount(Channel channel);

}
