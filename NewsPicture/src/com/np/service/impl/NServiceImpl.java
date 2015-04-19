package com.np.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.np.dao.AlbumDao;
import com.np.dao.ChannelDao;
import com.np.dao.PhotoDao;
import com.np.dao.UserDao;
import com.np.exception.NException;
import com.np.po.Album;
import com.np.po.Photo;
import com.np.po.User;
import com.np.service.NService;
import com.np.vo.AlbumHolder;
import com.np.vo.PhotoHolder;

public class NServiceImpl implements NService {
	// 业务逻辑组件所依赖的3个DAO组件

	@Autowired
	private UserDao userDao;
	@Autowired
	private PhotoDao photoDao;
	@Autowired
	private AlbumDao albumDao;
	@Autowired
	private ChannelDao channelDao;


	public void setChannelDao(ChannelDao channelDao) {
		this.channelDao = channelDao;
	}

	// 依赖注入3个DAO组件所需的setter方法
	public void setUserDao(UserDao ud) {
		this.userDao = ud;
	}

	public void setPhotoDao(PhotoDao pd) {
		this.photoDao = pd;
	}

	public void setAlbumDao(AlbumDao ad) {
		this.albumDao = ad;
	}

	/**
	 * 验证用户登录是否成功。
	 * 
	 * @param username
	 *            登录的用户名
	 * @param password
	 *            登录的密码
	 * @return 用户登录的结果，成功返回true，否则返回false
	 */
	public boolean userLogin(String username, String password) {
		try {
			// 使用UserDao根据用户名查询用户
			User u = userDao.findByName(username);
			if (u != null && u.getPassword().equals(password)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("处理用户登录出现异常！");
		}
	}

	/**
	 * 注册新用户
	 * 
	 * @param username
	 *            新注册用户的用户名
	 * @param password
	 *            新注册用户的密码
	 * @return 新注册用户的主键
	 */
	public int registUser(String username, String password) {
		try {
			// 创建一个新的User实例
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			// 持久化User对象
			userDao.save(u);
			return u.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("新用户注册出现异常！");
		}
	}

	/**
	 * 添加照片
	 * 
	 * @param user
	 *            添加相片的用户
	 * @param title
	 *            添加相片的标题
	 * @param fileName
	 *            新增相片在服务器上的文件名
	 * @param keyword
	 *            添加相片的关键词
	 * @return 新添加相片的主键
	 */
	public int addPhoto(String user, String title, String fileName,
			String keyword) {
		try {
			// 创建一个新的Photo实例
			Photo p = new Photo();
			p.setTitle(title);
			p.setFileName(fileName);
			p.setKeyword(keyword);
			p.setUser(userDao.findByName(user));
			// 持久化Photo实例
			photoDao.save(p);
			return p.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("添加相片过程中出现异常！");
		}
	}

	/**
	 * 根据用户获得该用户的所有相片
	 * 
	 * @param user
	 *            当前用户
	 * @param pageNo
	 *            页码
	 * @return 返回属于该用户、指定页的相片
	 */
	public List<PhotoHolder> getPhotoByUser(String user, int pageNo) {
		try {
			List<Photo> pl = photoDao.findByUser(userDao.findByName(user),
					pageNo);
			List<PhotoHolder> result = new ArrayList<PhotoHolder>();
			for (Photo p : pl) {
				result.add(new PhotoHolder(p.getTitle(), p.getFileName(), p
						.getKeyword()));
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("查询相片列表的过程中出现异常！");
		}
	}

	/**
	 * 添加图集
	 * 
	 * @param user
	 *            添加图集的用户
	 * @param title
	 *            添加图集的标题
	 * @return 新添加图集的主键
	 */
	public int addAlbum(String user, String title) {
		try {
			// 创建一个新的Album实例
			Album a = new Album();
			a.setTitle(title);
			a.setUser(userDao.findByName(user));
			// 持久化Album实例
			albumDao.save(a);
			return a.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("创建图集过程中出现异常！");
		}
	}

	/**
	 * 根据用户获得该用户的所有图集
	 * 
	 * @param user
	 *            当前用户
	 * @param pageNo
	 *            页码
	 * @return 返回属于该用户、指定页的相片
	 */
	public List<AlbumHolder> getAlbumByUser(String user, int pageNo) {
		try {
			List<Album> al = albumDao.findByUser(userDao.findByName(user),
					pageNo);
			List<AlbumHolder> result = new ArrayList<AlbumHolder>();
			for (Album a : al) {
				result.add(new AlbumHolder(a.getTitle()));
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("查询图集列表的过程中出现异常！");
		}
	}

	/**
	 * 验证用户名是否可用，即数据库里是否已经存在该用户名
	 * 
	 * @param username
	 *            需要校验的用户名
	 * @return 如果该用户名可用，返回true，否则返回false。
	 */
	public boolean validateName(String username) {
		try {
			// 根据用户名查询对应的User实例
			User u = userDao.findByName(username);
			if (u != null) {
				return false;
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("验证用户名是否存在的过程中出现异常！");
		}
	}
}
