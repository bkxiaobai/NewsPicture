package com.np.service;

import com.np.service.AService;
import com.np.exception.NException;
import com.np.dao.AdminDao;
import com.np.dao.ChannelDao;
import com.np.po.Admin;
import com.np.po.Channel;

public class AServiceImpl implements AService {
	private AdminDao ad;

	private ChannelDao cd;

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public void setCd(ChannelDao cd) {
		this.cd = cd;
	}

	public boolean adminlogin(String name, String pass) throws NException {
		try {
			Admin admin = ad.findByNameAndPass(name, pass);
			if (admin == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("登录异常");
		}
	}

	public void addChannel(String title) throws NException {
		try {
			Channel channel = new Channel(title);
			cd.save(channel);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("添加栏目异常");
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
			throw new NException("修改栏目信息异常");
		}
	}

	public void deleteChannel(int channelId)throws NException
	{
		//在配置文件Album.hbm.xml中将Photos 属性中加上了关闭延迟加载 不然的话会报一个异常
		try
		{
			cd.delete(channelId);		
		}
		catch (Exception e)
		{
			e.printStackTrace(); 			
			throw new NException("删除栏目异常");
		}
	}
	/**
	 * private AdminVO fillAdminVO(Admin admin)throws Exception { AdminVO avo =
	 * new AdminVO(admin.getId(), admin.getName(), admin.getPass()); return avo;
	 * }
	 **/
}
