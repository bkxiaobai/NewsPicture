package tests.com.np;

//import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.np.dao.AlbumDao;
import com.np.dao.ChannelDao;
import com.np.dao.PhotoDao;
import com.np.dao.UserDao;
//import com.np.po.Album;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AlbumTest {

	@Autowired
	UserDao userDao;
	@Autowired
	AlbumDao albumDao;
	@Autowired
	ChannelDao channelDao;
	@Autowired
	PhotoDao photoDao;

	/**@Test
	public void testFindAll() {

		List<Album> albums = albumDao.findAll();
		for (Album album : albums) {
			System.out.println(album.getTitle());
		}
		System.out.println("haaa");

	}

	@Test
	public void testFindByChannel() {
		List<Album> albums = albumDao.findByChannel(1,8);
		for (Album album : albums) {
			System.out.println(album.getTitle());
		}
		System.out.println("haaa");
	}

	@Test
	public void testCreate() {
		Album album = new Album();
		album.setChannel(channelDao.findById(1));
		album.setUser(userDao.findByName("hello"));
		album.setTitle("�Ǻ�");
		albumDao.save(album);
		System.out.println("create");

	}

	@Test
	public void testupdate() {
		Album album = albumDao.findById(1);
		album.setTitle("����");
		albumDao.update(album);
	}

	@Test
	public void testDelete() {
		Album album = albumDao.findById(1);
		albumDao.delete(album);
	}
**/
	@BeforeClass
	public static void before() {
	}

	public static void main(String[] args) {
		// Ĭ�϶�ȡhibernate.cfg.xml�ļ�.....

	}
}
