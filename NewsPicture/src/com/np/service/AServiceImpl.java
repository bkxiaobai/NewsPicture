package com.np.service;

import com.np.dao.ChannelDao;
import com.np.dao.UserDao;
import com.np.exception.NException;
import com.np.po.Channel;
import com.np.po.User;

public class AServiceImpl implements AService {
	private UserDao ud;

	private ChannelDao cd;

	public void setAd(UserDao ud) {
		this.ud = ud;
	}

	public void setCd(ChannelDao cd) {
		this.cd = cd;
	}

	public boolean adminlogin(String name, String pass) throws NException {
		try {
			User user = ud.findByNameAndPass(name, pass);
			if (user == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��¼�쳣");
		}
	}

	public void addChannel(String title) throws NException {
		try {
			Channel channel = new Channel(title);
			cd.save(channel);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("�����Ŀ�쳣");
		}
	}

	public void updateChannel(Integer channelId, String title)
			throws NException {
		try {
			Channel channel = cd.get(channelId);
			channel.setTitle(title);
			cd.save(channel);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("�޸���Ŀ��Ϣ�쳣");
		}
	}

	public void deleteChannel(int channelId)throws NException
	{
		//�������ļ�Album.hbm.xml�н�Photos �����м����˹ر��ӳټ��� ��Ȼ�Ļ��ᱨһ���쳣
		try
		{
			cd.delete(channelId);		
		}
		catch (Exception e)
		{
			e.printStackTrace(); 			
			throw new NException("ɾ����Ŀ�쳣");
		}
	}
	/**
	 * private AdminVO fillAdminVO(Admin admin)throws Exception { AdminVO avo =
	 * new AdminVO(admin.getId(), admin.getName(), admin.getPass()); return avo;
	 * }
	 **/
}
