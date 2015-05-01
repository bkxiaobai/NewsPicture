package com.np.service;

import java.util.Date;
import java.util.List;

import com.np.exception.NException;
import com.np.vo.AlbumVO;
import com.np.vo.ChannelVO;
import com.np.vo.PhotoVO;
import com.np.vo.UserVO;

public interface NService {

	// 添加相册
	void addAlbum(String title,String keyword, Date date, long times, Integer userId,
			Integer channelId) throws NException;

	// 跟新相册
	void updateAlbum(String title,String keyword, Integer channelId, Integer albumId)
			throws NException;

	// 跟新点击数
	void updateTimes(Integer albumId) throws NException;

	// 检查指定的相册是否含有相片
	boolean checkHavePhotos(int albumId) throws NException;

	// 删除相册
	void deleteAlbum(int albumId) throws NException;

	// 检查指定id的相册是否存在
	boolean checkAlbum(Integer id) throws NException;

	// 根据id获取相册资料
	AlbumVO getAlbum(Integer id) throws NException;

	// 设置相册封面
	void setCover(Integer albumId, Integer photoId) throws NException;

	// 用户登录
	boolean userLogin(String name, String pass) throws NException;

	// 获取指定用户的相册列表
	List<AlbumVO> getUserAlbums(int userId, int first, int pageSize)
			throws NException;

	// 获取指定用户的相册数量
	int getAlbumCount(int userId) throws NException;

	// 根据id获得指定相册的信息
	AlbumVO getUserAlbum(Integer id) throws NException;

	// 获取指定ID的用户信息
	UserVO getUserInfo(int userId) throws NException;

	// 判断指定用户名的用户是否存在
	boolean checkUserName(String username) throws NException;

	// 添加用户
	int addUser(String username, String password) throws NException;

	// 根据栏目来获取相册列表
	List<AlbumVO> getAlbumsByChannel(Integer channelId, int first, int pageSize)
			throws NException;

	// 获取指定栏目下的相册数量
	int getAlbumCount(Integer channelId) throws NException;

	// 获取指定栏目ID对应相册分类信息
	ChannelVO getChannel(Integer channelId) throws NException;

	// 根据相册获取该相册包含的相片。
	List<PhotoVO> getPhotos(Integer albumId, int first, int pageCount)
			throws NException;

	// 获取指定相册下包含相片数量
	int getCount(Integer albumId) throws NException;

	// 增加一张相片
	void addPhoto(String title, String keyword, long times, String picUrl,
			String bigPicUrl, String smallPicUrl, Date date, boolean cover,
			Integer albumId) throws NException;

	// 判断指定ID对应的相片是否存在。
	boolean checkPhoto(Integer photoId) throws NException;

	// 修改相片信息
	void updatePhoto(String title, String keyword, Integer albumId,
			Integer photoId) throws NException;

	// 更新点击数
	void updatePhotoTimes(Integer photoId) throws NException;

	// 删除指定相片
	void deletePhoto(int photoId) throws NException;

	// 判断指定ID获取对应的相片
	PhotoVO getPhoto(Integer photoId) throws NException;

	// 获取相片所属于的相册分类

	ChannelVO getChannelByPhoto(Integer photoId) throws NException;

	// 获取相册所属于的相册大类
	ChannelVO getChannelByAlbum(Integer AlbumId) throws NException;

	// 获取系统中全部相册分类
	List<ChannelVO> getAllChannel() throws NException;

	// 获得制定用户的相册
	List<AlbumVO> getMyAlbum(Integer userId) throws NException;

	// 修改用户的密码
	void updateUser(Integer id, String password) throws NException;
}