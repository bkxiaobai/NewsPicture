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
import com.np.po.Channel;
import com.np.po.Photo;
import com.np.po.User;
import com.np.service.NService;

public class NServiceImpl implements NService {
	// ҵ���߼������������3��DAO���

	@Autowired
	private UserDao userDao;
	@Autowired
	private PhotoDao photoDao;
	@Autowired
	private AlbumDao albumDao;
	@Autowired
	private ChannelDao channelDao;

	// ����ע��4��DAO��������setter����
	public void setChannelDao(ChannelDao cd) {
		this.channelDao = cd;
	}

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
	 * ��֤�û���¼�Ƿ�ɹ���
	 * 
	 * @param username
	 *            ��¼���û���
	 * @param password
	 *            ��¼������
	 * @return �û���¼�Ľ�����ɹ�����true�����򷵻�false
	 */
	@Override
	public boolean userLogin(String username, String password) {
		try {
			// ʹ��UserDao�����û�����ѯ�û�
			User u = userDao.findByName(username);
			if (u != null && u.getPassword().equals(password)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("�����û���¼�����쳣��");
		}
	}

	/**
	 * ע�����û�
	 * 
	 * @param username
	 *            ��ע���û����û���
	 * @param password
	 *            ��ע���û�������
	 * @return ��ע���û�������
	 */
	@Override
	public int registUser(String username, String password) {
		try {
			// ����һ���µ�Userʵ��
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			// �־û�User����
			userDao.save(u);
			return u.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("���û�ע������쳣��");
		}
	}

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
	@Override
	public int addPhoto(String title, String fileName, String keyword,
			String username, int album_id) {
		try {
			// ����һ���µ�Photoʵ��
			Photo p = new Photo();
			p.setTitle(title);
			p.setFileName(fileName);
			p.setKeyword(keyword);
			p.setUser(userDao.findByName(username));
			p.setAlbum(albumDao.findById(album_id));
			// �־û�Photoʵ��
			photoDao.save(p);
			return p.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("�����Ƭ�����г����쳣��");
		}
	}

	/**
	 * �����û���ø��û���������Ƭ
	 * 
	 * @param user
	 *            ��ǰ�û�
	 * @param pageNo
	 *            ҳ��
	 * @return �������ڸ��û���ָ��ҳ����Ƭ
	 */
	@Override
	public List<Photo> getPhotoByUser(User user, int pageNo) {
		try {
			List<Photo> photos = photoDao.findByUser(user.getId(), pageNo);
			List<Photo> result = new ArrayList<Photo>();
			for (Photo photo : photos) {
				result.add(new Photo(photo.getId(), photo.getTitle(), photo
						.getFileName(), photo.getKeyword(), photo.getUser(),
						photo.getAlbum()));
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("��ѯ��Ƭ�б�Ĺ����г����쳣��");
		}
	}

	//���ݵ�ǰ����ø���������ͼƬ
	public List<Photo> getPhotoByAlbum(Album album, int pageNo) {
		try {
			List<Photo> photos = photoDao.findByAlbum(album.getId(), pageNo);
			List<Photo> result = new ArrayList<Photo>();
			for (Photo photo : photos) {
				result.add(new Photo(photo.getId(), photo.getTitle(), photo
						.getFileName(), photo.getKeyword(), photo.getUser(),
						photo.getAlbum()));
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("��ѯ��Ƭ�б�Ĺ����г����쳣��");
		}
	}

	/**
	 * ���ͼ��
	 * 
	 * @param user
	 *            ���ͼ�����û�
	 * @param title
	 *            ���ͼ���ı���
	 * @return �����ͼ��������
	 */
	@Override
	public int addAlbum(String username,int Channel_id, String title) {
		try {
			// ����һ���µ�Albumʵ��
			Album a = new Album();
			a.setTitle(title);
			a.setUser(userDao.findByName(username));
			a.setChannel(channelDao.findById(Channel_id));
			// �־û�Albumʵ��
			albumDao.save(a);
			return a.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("����ͼ�������г����쳣��");
		}
	}

	/**
	 * �����û���ø��û�������ͼ��
	 * 
	 * @param user
	 *            ��ǰ�û�
	 * @param pageNo
	 *            ҳ��
	 * @return �������ڸ��û���ָ��ҳ����Ƭ
	 */
	@Override
	public List<Album> getAlbumByUser(User user, int pageNo) {
		try {
			List<Album> albums = albumDao.findByUser(user.getId(), pageNo);
			List<Album> result = new ArrayList<Album>();
			for (Album album : albums) {
				result.add(new Album(album.getId(), album.getTitle(), album
						.getUser(), album.getChannel()));
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("��ѯͼ���б�Ĺ����г����쳣��");
		}
	}

	public List<Album> getAlbumByChannel(Channel channel, int pageNo) {
		try {
			List<Album> albums = albumDao.findByChannel(channel.getId(), pageNo);
			List<Album> result = new ArrayList<Album>();
			for (Album album : albums) {
				result.add(new Album(album.getId(), album.getTitle(), album
						.getUser(), album.getChannel()));
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("��ѯͼ���б�Ĺ����г����쳣��");
		}
	}
	/**
	 * ��֤�û����Ƿ���ã������ݿ����Ƿ��Ѿ����ڸ��û���
	 * 
	 * @param username
	 *            ��ҪУ����û���
	 * @return ������û������ã�����true�����򷵻�false��
	 */
	@Override
	public boolean validateName(String username) {
		try {
			// �����û�����ѯ��Ӧ��Userʵ��
			User u = userDao.findByName(username);
			if (u != null) {
				return false;
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("��֤�û����Ƿ���ڵĹ����г����쳣��");
		}
	}

	// ������Ŀ
	public int addChannel(String title) {
		try {
			// ����һ���µ�Channelʵ��
			Channel c = new Channel();
			c.setTitle(title);
			// �־û�Channelʵ��
			channelDao.save(c);
			return c.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("������Ŀ�����г����쳣��");
		}
	}

	public List<Channel> getChannel() {
		try {
			List<Channel> channels = channelDao.findAll();
			List<Channel> result = new ArrayList<Channel>();
			for (Channel channel : channels) {
				result.add(new Channel(channel.getId(), channel.getTitle()));
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NException("��ѯ��Ŀ�б�Ĺ����г����쳣��");
		}
	}
	
}
