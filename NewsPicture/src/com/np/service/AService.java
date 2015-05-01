package com.np.service;

import com.np.exception.NException;
import com.np.vo.AdminVO;

public interface AService {
	AdminVO checkAdmin(String name, String pass) throws NException;

	void addChannel(String title) throws NException;

	void updateChannel(Integer channelId, String title) throws NException;

	void deleteChannel(int channelId) throws NException;
}
