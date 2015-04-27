package com.np.dao;

import java.util.List;

import com.np.po.Channel;

//ChannelDao�ӿ�
public interface ChannelDao {

	// ���ݱ�ʶ������������Ŀ,��Ҫ������Ŀ��id,ָ��id��Ӧ����Ŀ
	Channel findById(Integer id);

	// �־û���Ŀ
	Integer save(Channel channel);

	// �޸���Ŀ
	void update(Channel channel);

	// ɾ��ָ����Ŀ
	void delete(Channel channel);

	// ����������Ŀ
	List<Channel> findAll();
	
	Channel findByTitle(String title);
	
}
