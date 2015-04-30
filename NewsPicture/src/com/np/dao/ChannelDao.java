package com.np.dao;

import java.util.List;

import com.np.po.Album;
import com.np.po.Channel;

//ChannelDao�ӿ�
public interface ChannelDao {
	// ���ݱ�ʾ���Լ���
	Channel get(Integer id);

	// �־û���Ŀ
	void save(Channel channel);

	// �޸���Ŀ
	void update(Channel channel);

	// ɾ��ָ����Ŀ
	void delete(Channel channel);
    
	//idɾ��
	void delete(int id);
	
	//��ѯ������Ŀ
	List<Channel> getAll();
	
	// �õ���Ŀ���������
	List<Album> getAllByChannel(final Channel channel, final int first,
			final int pageSize);

	// ��ȡ��Ŀ���������
	int getAmount(Channel channel);

}
