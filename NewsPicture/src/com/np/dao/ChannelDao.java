package com.np.dao;

import com.np.po.Channel;

//ChannelDao�ӿ�
public interface ChannelDao {

	// ���ݱ�ʶ������������Ŀ,��Ҫ������Ŀ��id,ָ��id��Ӧ����Ŀ
	Channel get(Integer id);

	// �־û���Ŀ
	Integer save(Channel channel);

	// �޸���Ŀ
	void update(Channel channel);

	// ɾ��ָ����Ŀ
	void delete(Channel channel);

	// ����idɾ����Ŀ
	void delete(Integer id);

}