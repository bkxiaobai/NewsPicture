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
		// 栏目
		Channel channel = new Channel();
		channel.setTitle("first channel");
		channelDao.save(channel);
		
		
		// 用户
		User user = new User();
		user.setUsername("hello");
		user.setPassword("world");
		userDao.save(user);
		
		
		// 相册
		Album album = new Album();
		album.setTitle("my-album");
		
		album.setUser(user);;
		album.setChannel(channel);
		albumDao.save(album);
		
		
		// 照片
		Photo photo = new Photo();
		photo.setTitle("my-photo");
		photo.setFileName("xxx.jpg");
		photo.setKeyword("life");
		
		photo.setUser(user);
		photo.setAlbum(album);
		photoDao.save(photo);
	}

}
