package com.np.service;

import java.util.List;

import com.np.po.Album;
import com.np.po.Channel;
import com.np.po.Photo;
import com.np.po.User;

public interface NService {
	/**
	 * ��֤�û���¼�Ƿ�ɹ���
	 * 
	 * @param username
	 *            ��¼���û���
	 * @param password
	 *            ��¼������
	 * @return �û���¼�Ľ�����ɹ�����true�����򷵻�false
	 */
	boolean userLogin(String username, String password);

	/**
	 * ע�����û�
	 * 
	 * @param username
	 *            ��ע���û����û���
	 * @param password
	 *            ��ע���û�������
	 * @return ��ע���û�������
	 */
	int registUser(String username, String password);

	/**
	 * �����Ƭ
	 * 
	 * @param user
	 *            �����Ƭ���û�
	 * @param title
	 *            �����Ƭ�ı���
	 * @param fileName
	 *            ������Ƭ�ڷ������ϵ��ļ���
	 * @param keyword
	 *            �����Ƭ�Ĺؼ���
	 * @return �������Ƭ������
	 */
	int addPhoto(String title, String fileName, String keyword,
			String username, int album_id);

	/**
	 * �����û���ø��û���������Ƭ
	 * 
	 * @param user
	 *            ��ǰ�û�
	 * @param pageNo
	 *            ҳ��
	 * @return �������ڸ��û���ָ��ҳ����Ƭ
	 */
	List<Photo> getPhotoByUser(User user, int pageNo);

	List<Photo> getPhotoByAlbum(Album album, int pageNo);

	/**
	 * ���ͼ��
	 * 
	 * @param user
	 *            ���ͼ�����û�
	 * @param title
	 *            ���ͼ���ı���
	 * @return �����ͼ��������
	 */
	int addAlbum(String user,int channel_id, String title);

	int addChannel(String title);

	/**
	 * �����û���ø��û�������ͼ��
	 * 
	 * @param user
	 *            ��ǰ�û�
	 * @param pageNo
	 *            ҳ��
	 * @return �������ڸ��û���ָ��ҳ����Ƭ
	 */
	List<Album> getAlbumByUser(User user, int pageNo);

	List<Album> getAlbumByChannel(Channel channel, int pageNo);

	List<Channel> getChannel();

	/**
	 * ��֤�û����Ƿ���ã������ݿ����Ƿ��Ѿ����ڸ��û���
	 * 
	 * @param username
	 *            ��ҪУ����û���
	 * @return ������û������ã�����true�����򷵻�false��
	 */
	boolean validateName(String username);
}
