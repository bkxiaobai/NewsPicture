package tests.com.np;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.np.dao.AlbumDao;
import com.np.dao.ChannelDao;
import com.np.dao.PhotoDao;
import com.np.dao.UserDao;
import com.np.po.Album;
import com.np.po.Channel;
import com.np.po.Photo;
import com.np.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ServiceTest {
    @Autowired
    UserDao userDao;
    @Autowired
    ChannelDao channelDao;
    @Autowired
    AlbumDao albumDao;
    @Autowired
    PhotoDao photoDao;
    
	@Test
	public void testAll() {
		// ��Ŀ
		Channel channel = new Channel();
		channel.setTitle("2 channel");
		channelDao.save(channel);
		
		
		// �û�
		User user = new User(null, null);
		user.setUsername("ddd");
		user.setPassword("world");
		userDao.save(user);
		
		
		// ���
		Album album = new Album();
		album.setTitle("ddd");
		album.setUser(user);
		album.setChannel(channel);
		albumDao.save(album);
		
		
		// ��Ƭ
		Photo photo = new Photo();
		photo.setTitle("ddo");
		photo.setKeyword("life");
		photo.setCover(false);
		photo.setAlbum(album);
		photoDao.save(photo);
	}

}
