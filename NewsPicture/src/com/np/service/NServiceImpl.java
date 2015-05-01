package com.np.service;

import com.np.service.NService;
import com.np.dao.PhotoDao;
import com.np.dao.UserDao;
import com.np.dao.AlbumDao;
import com.np.dao.ChannelDao;
import com.np.po.Photo;
import com.np.po.User;
import com.np.po.Channel;
import com.np.po.Album;
import com.np.vo.PhotoVO;
import com.np.vo.UserVO;
import com.np.vo.AlbumVO;
import com.np.vo.ChannelVO;
import com.np.exception.NException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class NServiceImpl implements NService {
	// ҵ���߼�����־û�����������PhotoDao���
	private PhotoDao pd;
	// ҵ���߼�����־û�����������UserDao���
	private UserDao ud;
	// ҵ���߼�����־û�����������AlbumDao���
	private AlbumDao ad;
	// ҵ���߼�����־û�����������ChannelDao���
	private ChannelDao cd;

	// spring��ioc��ʵ��

	// ����ע�����DAO����������setter����
	public void setAd(AlbumDao ad) {
		this.ad = ad;
	}

	public void setPd(PhotoDao pd) {
		this.pd = pd;
	}

	public void setKd(ChannelDao cd) {
		this.cd = cd;
	}

	public void setCd(UserDao ud) {
		this.ud = ud;
	}

	/**
	 * �������
	 * 
	 * @param title
	 *            �������
	 * @param date
	 *            ���Ĵ���ʱ�䡣
	 * @param times
	 *            ���ķ��ʴ�����
	 * @param userId
	 *            ���Ĵ�����ID
	 * @param channelId
	 *            ���������������ID
	 */
	public void addAlbum(String title, String keyword, String date, long times,
			Integer userId, Integer channelId) throws NException {
		try {
			User user = ud.get(userId);
			Channel channel = cd.get(channelId);
			Album album = new Album(title, keyword, date, times, user, channel);
			ad.save(album);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("�������쳣,������");
		}
	}

	/**
	 * �������
	 * 
	 * @param title
	 *            �������
	 * @param desc
	 *            �������
	 * @param kindId
	 *            ��Ҫ������޸�Ϊ�������ࡣ
	 * @param albumId
	 *            ���ID
	 */
	public void updateAlbum(String title, String keyword, Integer channelId,
			Integer albumId) throws NException {
		try {
			Album album = ad.get(albumId);
			Channel channel = cd.get(channelId);
			album.setChannel(channel);
			album.setTitle(title);
			album.setKeyword(keyword);
			ad.update(album);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("�޸������Ϣ�쳣");
		}

	}

	/**
	 * ���µ����
	 */
	public void updateTimes(Integer albumId) throws NException {
		try {
			Album album = ad.get(albumId);
			album.setTimes(album.getTimes() + 1);
			ad.update(album);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("���µ���������쳣");
		}
	}

	/**
	 * �ж�������Ƿ�����Ƭ
	 * 
	 * @param albumId
	 * @return
	 */
	public boolean checkHavePhotos(int albumId) throws NException {
		try {
			Album album = ad.get(albumId);
			if (album.getPhotos().isEmpty())
				return false;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("����Ƿ�����Ƭ�쳣��������");
		}
	}

	/**
	 * ɾ�����
	 * 
	 * @param albumId
	 *            ��Ҫɾ�������ID
	 */
	public void deleteAlbum(int albumId) throws NException {
		// �������ļ�Album.hbm.xml�н�Photos �����м����˹ر��ӳټ��� ��Ȼ�Ļ��ᱨһ���쳣
		try {
			ad.delete(albumId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("ɾ������쳣");
		}
	}

	/**
	 * ���ָ��ID������Ƿ����
	 * 
	 * @param id
	 *            ��Ҫ�������ID
	 * @return ���ڷ���true�������ڷ���false��
	 */
	public boolean checkAlbum(Integer id) throws NException {
		try {
			Album album = ad.get(id);
			if (album == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("�����������쳣��������");
		}

	}

	/**
	 * ����ID����ȡ������ϡ�
	 * 
	 * @param id
	 *            ��Ҫ��ȡ������ϵ�ID��
	 * @return ָ��ID��Ӧ�����ֵ����
	 */
	public AlbumVO getAlbum(Integer id) throws NException {
		try {
			AlbumVO vo = null;
			Album album = ad.get(id);
			if (pd.getCover(album, true) == null) {
				vo = fillAlbumVO(album);
			} else {
				Photo ph = pd.get(pd.getCover(album, true));
				vo = fillAlbumVO(album, ph);
			}
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��ȡ��������쳣");
		}
	}

	/**
	 * ����������
	 * 
	 * @param albumId
	 *            ָ�����ID
	 * @param photoId
	 *            ��Ҫ����Ϊ���������ƬID
	 */
	public void setCover(Integer albumId, Integer photoId) throws NException {
		try {
			Album album = ad.get(albumId);
			Photo photo = pd.get(photoId);
			Photo coverPhoto = pd.getCoverPhoto(album, true);
			if (coverPhoto == null) {
				photo.setCover(true);
				pd.update(photo);
			} else {
				coverPhoto.setCover(false);
				photo.setCover(true);
				pd.update(photo);
				pd.update(coverPhoto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("�����������쳣");
		}
	}

	/**
	 * �����û���������У���û���¼
	 * 
	 * @param name
	 *            ��ҪУ����û���
	 * @param pass
	 *            ��ҪУ�������
	 * @return ��ѯ�û��������ѯ�����û�����false
	 */
	public int checkUser(String username, String password) throws NException {
		try {
			Integer id = ud.findByNameAndPass(username, password);
			if (id == null) {
				return -1;
			}
			return id.intValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("����û��쳣,������");
		}
	}

	/**
	 * ��ȡָ���û�������б�
	 * 
	 * @param clientId
	 *            ָ���û���ID
	 * @param first
	 *            ��Ҫ��ʾ�ĵ�һ���ID
	 * @param pageSize
	 *            ÿҳ��ʾ�����������
	 * @return ���û���Ӧ������б�
	 */
	public List<AlbumVO> getUserAlbums(int userId, int first, int pageSize)
			throws NException {
		try {
			User user = ud.get(userId);
			List<Album> result = ad.getAllByUser(user, first, pageSize);
			List<AlbumVO> vos = new ArrayList<AlbumVO>();
			for (Iterator<Album> it = result.iterator(); it.hasNext();) {
				AlbumVO vo = null;
				Album al = (Album) it.next();
				if (pd.getCover(al, true) == null) {
					vo = fillAlbumVO(al);
				} else {
					Photo ph = pd.get(pd.getCover(al, true));
					vo = fillAlbumVO(al, ph);
				}
				vos.add(vo);
			}
			return vos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��ȡ�û�����쳣");
		}
	}

	/**
	 * ��ȡָ���û������������
	 * 
	 * @param userId
	 *            ��Ҫ�������������û�ID
	 * @return ���û����������
	 */
	public int getAlbumCount(int userId) throws NException {
		try {
			User user = ud.get(userId);
			return ad.getAmount(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��ȡ��������쳣");
		}

	}

	/**
	 * ����ID��ȡָ��������Ϣ
	 * 
	 * @param id
	 *            ָ�������ID
	 * @return ��������Ϣ
	 */
	public AlbumVO getUserAlbum(Integer id) throws NException {
		try {
			Album album = ad.get(id);
			if (album == null) {
				return null;
			}
			return fillAlbumVO(album);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��ȡ���������Ϣ�쳣");
		}
	}

	/*
	 * ��ȡָ��ID���û���Ϣ
	 * 
	 * @param userId ָ���û����û�ID��
	 * 
	 * @return ָ���û�����ϸ��Ϣ
	 */
	public UserVO getUserInfo(int userId) throws NException {
		try {
			User user = ud.get(userId);
			if (user == null) {
				return null;
			}
			return fillUserInfoVO(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��ȡ�û������쳣,������");
		}
	}

	/**
	 * �ж�ָ���û������û��Ƿ����
	 * 
	 * @param name
	 *            ��Ҫ�жϵ��û���
	 * @return ������û�����Ӧ���û����ڣ��򷵻�true�����򷵻�false
	 */
	public boolean checkUserName(String username) throws NException {
		try {
			if (ud.findByName(username) == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("�����û���ʱ�����쳣");
		}
	}

	/**
	 * ����û�
	 * 
	 * @param name
	 *            ����û����û���
	 * @param pass
	 *            ����û�������
	 * @param sex
	 *            ����û�������
	 * @param mail
	 *            ����û��ĵ����ʼ���
	 * @return �����û�������ֵ
	 */
	public int addUser(String username, String password) throws NException {
		try {
			User user = new User(username, password);
			ud.save(user);
			return user.getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("ע���û�ʱ�����쳣");
		}
	}

	/**
	 * ������������ȡ����б�
	 * 
	 * @param ChannelId
	 *            ��Ҫ��ȡ���������ID
	 * @param first
	 *            ��Ҫ��ʾ�ĵ�һ�����
	 * @param pageSize
	 *            ÿҳ��ʾ���������
	 * @return ��ѯ��������б�
	 */
	public List<AlbumVO> getAlbumsByChannel(Integer channelId, int first,
			int pageSize) throws NException {
		try {
			Channel channel = cd.get(channelId);
			List<AlbumVO> avos = new ArrayList<AlbumVO>();
			List<Album> albums = cd.getAllByChannel(channel, first, pageSize);
			for (Iterator<Album> it = albums.iterator(); it.hasNext();) {
				AlbumVO avo = null;
				Album album = (Album) it.next();
				if (pd.getCover(album, true) == null) {
					avo = fillAlbumVO(album);
				} else {
					Photo ph = pd.get(pd.getCover(album, true));
					avo = fillAlbumVO(album, ph);
				}
				avos.add(avo);
			}
			return avos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("�쳣");
		}
	}

	/**
	 * ��ȡָ���������µ��������
	 * 
	 * @param channelId
	 *            ��Ҫ��ѯ��������ID
	 * @return ָ���������µ��������
	 */
	public int getAlbumCount(Integer channelId) throws NException {
		try {
			Channel channel = cd.get(channelId);
			return cd.getAmount(channel);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��ѯ��������쳣");
		}
	}

	/**
	 * ��ȡָ��������ID��Ӧ��������Ϣ
	 * 
	 * @param channelId
	 *            ��Ҫ��ѯ��������ID
	 * @return ָ��������ID��Ӧ����������Ϣ
	 */
	public ChannelVO getChannel(Integer channelId) throws NException {
		try {
			Channel channel = cd.get(channelId);
			return fillChannelVO(channel);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��ȡ���������쳣");
		}
	}

	/**
	 * ��������ȡ������������Ƭ��
	 * 
	 * @param albumId
	 *            ��Ҫ��ѯ�����ID
	 * @param first
	 *            ��Ҫ��ʾ�ĵ�һ����Ƭ
	 * @param pageCount
	 *            ÿҳ��ʾ����Ƭ����
	 * @return ��ѯ������������ȫ����Ƭ��
	 */
	public List<PhotoVO> getPhotos(Integer albumId, int first, int pageCount)
			throws NException {
		try {
			Album album = ad.get(albumId);
			List<Photo> result = pd.getPhotos(album, first, pageCount);
			List<PhotoVO> pvos = new ArrayList<PhotoVO>();
			for (Iterator<Photo> it = result.iterator(); it.hasNext();) {
				Photo ph = (Photo) it.next();
				pvos.add(fillPhotoVO(ph));
			}
			return pvos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��ѯ�������Ƭ�쳣,������");
		}
	}

	/**
	 * ��ȡָ������°�����Ƭ����
	 * 
	 * @param albumId
	 *            ָ������ID
	 * @return ������°�������ƬID��
	 */
	public int getCount(Integer albumId) throws NException {
		try {
			Album album = ad.get(albumId);
			return pd.getCount(album);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��ȡ��¼�����쳣,������");
		}
	}

	/**
	 * ��ȡ��������ڵ�������
	 * 
	 * @param AlbumId
	 *            ��Ҫ��ѯ�����ID
	 * @return ָ������Ӧ�������ࡣ
	 */
	public ChannelVO getChannelByAlbum(Integer AlbumId) throws NException {
		try {
			Channel channel = ad.get(AlbumId).getChannel();
			return fillChannelVO(channel);
		} catch (Exception e) {

			throw new NException("��ȡ��Ƭ�����쳣");
		}
	}

	/**
	 * ����һ����Ƭ
	 * 
	 * @param title
	 *            ��Ƭ����
	 * @param keyword
	 *            ��Ƭ����
	 * @param times
	 *            ��Ƭ���ʴ�����
	 * @param picUrl
	 *            ��Ƭ��URL
	 * @param bigPicUrl
	 *            ��Ƭ��ͼ��URL
	 * @param smallPicUrl
	 *            ��ƬСͼ��URL
	 * @param date
	 *            ��Ƭ���������
	 * @param cover
	 *            �Ƿ�Ϊ�����档
	 * @param albumId
	 *            ����Ƭ��Ҫ��ӵ������ID
	 */
	public void addPhoto(String title, String keyword, long times,
			String picUrl, String bigPicUrl, String smallPicUrl, String date,
			boolean cover, Integer albumId) throws NException {
		try {
			Album album = ad.get(albumId);
			Photo photo = new Photo(title, keyword, times, picUrl, bigPicUrl,
					smallPicUrl, date, cover, album);
			pd.save(photo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("�����Ƭ�쳣,������");
		}
	}

	/**
	 * �޸���Ƭ��Ϣ
	 */
	public void updatePhoto(String title, String keyword, Integer albumId,
			Integer photoId) throws NException {
		try {
			Photo photo = pd.get(photoId);
			photo.setTitle(title);
			photo.setKeyword(keyword);
			photo.setCover(false);
			Album album = ad.get(albumId);
			photo.setAlbum(album);
			pd.update(photo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("�޸���Ƭ��Ϣʱ�����쳣");
		}
	}

	/**
	 * ���µ����
	 * 
	 * @param phId
	 *            ���µ����Ƭ�ĵ����
	 */
	public void updatePhotoTimes(Integer photoId) throws NException {
		try {
			Photo photo = pd.get(photoId);
			photo.setTimes(photo.getTimes() + 1);
			pd.update(photo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("���µ���������쳣");
		}
	}

	/**
	 * �ж�ָ��ID��Ӧ����Ƭ�Ƿ���ڡ�
	 * 
	 * @param ��Ҫ��ѯ����ƬID
	 * @return �����ID��Ӧ����Ƭ���ڣ�����true�����򷵻�false��
	 */
	public boolean checkPhoto(Integer photoId) throws NException {
		try {
			Photo photo = pd.get(photoId);
			if (photo == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("У����Ƭ�����쳣");
		}
	}

	/**
	 * ɾ��ָ����Ƭ
	 * 
	 * @param ��Ҫɾ������ƬID
	 */
	public void deletePhoto(int photoId) throws NException {
		try {
			pd.delete(photoId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("ɾ����Ƭ�쳣");
		}
	}

	/**
	 * �ж�ָ��ID��ȡ��Ӧ����Ƭ
	 * 
	 * @param ��Ҫ��ѯ����ƬID
	 * @return ���ظ�ID��Ӧ����Ƭ
	 */
	public PhotoVO getPhoto(Integer photoId) throws NException {
		try {
			Photo photo = pd.get(photoId);
			PhotoVO pvo = fillPhotoVO(photo);
			return pvo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��ѯ��Ƭ��Ϣ�쳣");
		}
	}

	/**
	 * ��ȡ��Ƭ�����ڵ�������
	 * 
	 * @param photoId
	 *            ��Ҫ��ѯ����ƬID
	 * @return ָ����Ƭ��Ӧ�������ࡣ
	 */
	public ChannelVO getChannelByPhoto(Integer photoId) throws NException {
		try {
			Channel channel = pd.get(photoId).getAlbum().getChannel();
			return fillChannelVO(channel);
		} catch (Exception e) {

			throw new NException("��ȡ��Ƭ�����쳣");
		}
	}

	/**
	 * ��ȡϵͳ��ȫ��������
	 * 
	 * @return ϵͳ������ȫ��������
	 */
	public List<ChannelVO> getAllChannel() throws NException {
		try {
			List<ChannelVO> result = new ArrayList<ChannelVO>();
			List<Channel> channels = cd.getAll();
			for (Iterator<Channel> it = channels.iterator(); it.hasNext();) {
				Channel channel = (Channel) it.next();
				result.add(fillChannelVO(channel));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��ȡ���������쳣");
		}

	}

	/**
	 * ��ȡ��ǰ�û���������
	 * 
	 * @param cId
	 *            �û�������ֵ��
	 */
	public List<AlbumVO> getMyAlbum(Integer userId) throws NException {
		try {
			User user = ud.get(userId);
			List<AlbumVO> result = new ArrayList<AlbumVO>();
			List<Album> albums = ad.getAllByUser(user);
			for (Iterator<Album> it = albums.iterator(); it.hasNext();) {
				Album album = (Album) it.next();
				result.add(fillAlbumVO(album));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("��ȡ���������쳣");
		}

	}

	/**
	 * �޸��û�������
	 * 
	 * @param id
	 *            ��Ҫ�޸ĵ��û�ID��Ϣ
	 * @param pass
	 *            ��Ҫ�޸ĵ��û�������
	 */
	public void updateUser(Integer id, String password) throws NException {
		try {
			User user = ud.get(id);
			user.setPassword(password);
			ud.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NException("�޸������쳣");
		}

	}

	// --------------------------------------------------
	// ��������������ڽ�POת����VO�Ĺ��߷�����
	// --------------------------------------------------
	private UserVO fillUserInfoVO(User user) throws Exception {
		UserVO uvo = new UserVO(user.getId(), user.getUsername(),
				user.getPassword());
		return uvo;
	}

	private AlbumVO fillAlbumVO(Album album, Photo photo) throws Exception {
		AlbumVO avo = null;
		avo = new AlbumVO(album.getId(), album.getTitle(), album.getKeyword(),
				album.getDate(), album.getTimes(), album.getUser().getId(),
				album.getUser().getUsername(), album.getChannel().getId(),
				album.getChannel().getTitle(), photo.getId(),
				photo.getSmallPicUrl());
		return avo;
	}

	private AlbumVO fillAlbumVO(Album album) throws Exception {
		AlbumVO avo = null;
		avo = new AlbumVO(album.getId(), album.getTitle(), album.getKeyword(),
				album.getDate(), album.getTimes(), album.getUser().getId(),
				album.getUser().getUsername(), album.getChannel().getId(),
				album.getChannel().getTitle());
		return avo;
	}

	private ChannelVO fillChannelVO(Channel channel) throws Exception {
		ChannelVO cvo = new ChannelVO(channel.getId(), channel.getTitle());
		return cvo;
	}

	private PhotoVO fillPhotoVO(Photo photo) throws Exception {
		PhotoVO pvo = new PhotoVO(photo.getId(), photo.getTitle(),
				photo.getKeyword(), photo.getTimes(), photo.getPicUrl(),
				photo.getBigPicUrl(), photo.getSmallPicUrl(), photo.getDate(),
				photo.isCover(), photo.getAlbum().getId(), photo.getAlbum()
						.getTitle());
		return pvo;
	}

}
