package tests.com.np;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.np.dao.ChannelDao;
import com.np.dao.AlbumDao;
import com.np.dao.PhotoDao;
import com.np.po.Album;
import com.np.po.Channel;
import com.np.po.Photo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ChannelTest {

    @Autowired
	AlbumDao albumDao;
	@Autowired
	ChannelDao channelDao;
	@Autowired
	PhotoDao photoDao;




		@Test
		public void testCreate() {
			Channel channel = new Channel();
			channel.setTitle("user-test");
			channelDao.save(channel);
			System.out.println("create");
		}


		@Test
		public void testupdate() {
			Channel channel = channelDao.findByTitle("first channel");
			channel.setTitle("风景");
			channelDao.update(channel);
		}
		
		@Test
		public void testDelete() {
			List<Album> albums = albumDao.findByChannel(1);
			for (Album album : albums) {
				albumDao.get(null);
				List<Photo> photos = photoDao.findByAlbum();
				
				for (Photo photo : photos) {
				Assert.assertNotNull(photo);
		        photoDao.delete(photo);    }
				
				Album album = albumDao.get();
				Assert.assertNotNull(album);
				albumDao.delete(album);  
				                       }
			
			Channel channel = channelDao.get(1);
			Assert.assertNotNull(channel);
			channelDao.delete(channel);
		}


		@BeforeClass
		public static void before() {
		}

		public static void main(String[] args) {
			// 默认读取hibernate.cfg.xml文件.....

		}

}
