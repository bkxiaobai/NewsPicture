package com.np.service;

import java.util.Date;
import java.util.List;

import com.np.exception.NException;
import com.np.vo.AlbumVO;
import com.np.vo.ChannelVO;
import com.np.vo.PhotoVO;
import com.np.vo.UserVO;

public interface NService {

	// ������
	void addAlbum(String title,String keyword, Date date, long times, Integer userId,
			Integer channelId) throws NException;

	// �������
	void updateAlbum(String title,String keyword, Integer channelId, Integer albumId)
			throws NException;

	// ���µ����
	void updateTimes(Integer albumId) throws NException;

	// ���ָ��������Ƿ�����Ƭ
	boolean checkHavePhotos(int albumId) throws NException;

	// ɾ�����
	void deleteAlbum(int albumId) throws NException;

	// ���ָ��id������Ƿ����
	boolean checkAlbum(Integer id) throws NException;

	// ����id��ȡ�������
	AlbumVO getAlbum(Integer id) throws NException;

	// ����������
	void setCover(Integer albumId, Integer photoId) throws NException;

	// �û���¼
	boolean userLogin(String name, String pass) throws NException;

	// ��ȡָ���û�������б�
	List<AlbumVO> getUserAlbums(int userId, int first, int pageSize)
			throws NException;

	// ��ȡָ���û����������
	int getAlbumCount(int userId) throws NException;

	// ����id���ָ��������Ϣ
	AlbumVO getUserAlbum(Integer id) throws NException;

	// ��ȡָ��ID���û���Ϣ
	UserVO getUserInfo(int userId) throws NException;

	// �ж�ָ���û������û��Ƿ����
	boolean checkUserName(String username) throws NException;

	// ����û�
	int addUser(String username, String password) throws NException;

	// ������Ŀ����ȡ����б�
	List<AlbumVO> getAlbumsByChannel(Integer channelId, int first, int pageSize)
			throws NException;

	// ��ȡָ����Ŀ�µ��������
	int getAlbumCount(Integer channelId) throws NException;

	// ��ȡָ����ĿID��Ӧ��������Ϣ
	ChannelVO getChannel(Integer channelId) throws NException;

	// ��������ȡ������������Ƭ��
	List<PhotoVO> getPhotos(Integer albumId, int first, int pageCount)
			throws NException;

	// ��ȡָ������°�����Ƭ����
	int getCount(Integer albumId) throws NException;

	// ����һ����Ƭ
	void addPhoto(String title, String keyword, long times, String picUrl,
			String bigPicUrl, String smallPicUrl, Date date, boolean cover,
			Integer albumId) throws NException;

	// �ж�ָ��ID��Ӧ����Ƭ�Ƿ���ڡ�
	boolean checkPhoto(Integer photoId) throws NException;

	// �޸���Ƭ��Ϣ
	void updatePhoto(String title, String keyword, Integer albumId,
			Integer photoId) throws NException;

	// ���µ����
	void updatePhotoTimes(Integer photoId) throws NException;

	// ɾ��ָ����Ƭ
	void deletePhoto(int photoId) throws NException;

	// �ж�ָ��ID��ȡ��Ӧ����Ƭ
	PhotoVO getPhoto(Integer photoId) throws NException;

	// ��ȡ��Ƭ�����ڵ�������

	ChannelVO getChannelByPhoto(Integer photoId) throws NException;

	// ��ȡ��������ڵ�������
	ChannelVO getChannelByAlbum(Integer AlbumId) throws NException;

	// ��ȡϵͳ��ȫ��������
	List<ChannelVO> getAllChannel() throws NException;

	// ����ƶ��û������
	List<AlbumVO> getMyAlbum(Integer userId) throws NException;

	// �޸��û�������
	void updateUser(Integer id, String password) throws NException;
}