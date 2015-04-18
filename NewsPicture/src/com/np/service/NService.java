package com.np.service;

import java.util.List;
import com.np.vo.PhotoHolder;

public interface NService {
	/**
	 * 验证用户登录是否成功。
	 * 
	 * @param username
	 *            登录的用户名
	 * @param password
	 *            登录的密码
	 * @return 用户登录的结果，成功返回true，否则返回false
	 */
	boolean userLogin(String username, String password);

	/**
	 * 注册新用户
	 * 
	 * @param username
	 *            新注册用户的用户名
	 * @param password
	 *            新注册用户的密码
	 * @return 新注册用户的主键
	 */
	int registUser(String username, String password);

	/**
	 * 添加照片
	 * 
	 * @param user
	 *            添加相片的用户
	 * @param title
	 *            添加相片的标题
	 * @param fileName
	 *            新增相片在服务器上的文件名
	 * @return 新添加相片的主键
	 */
	int addPhoto(String user, String title, String fileName);

	/**
	 * 根据用户获得该用户的所有相片
	 * 
	 * @param user
	 *            当前用户
	 * @param pageNo
	 *            页码
	 * @return 返回属于该用户、指定页的相片
	 */
	List<PhotoHolder> getPhotoByUser(String user, int pageNo);

	/**
	 * 验证用户名是否可用，即数据库里是否已经存在该用户名
	 * 
	 * @param username
	 *            需要校验的用户名
	 * @return 如果该用户名可用，返回true，否则返回false。
	 */
	boolean validateName(String username);
}
