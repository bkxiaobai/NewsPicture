package tests.com.np;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.np.dao.AlbumDao;
import com.np.dao.PhotoDao;
import com.np.dao.UserDao;
import com.np.po.Photo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class PhotoTest {

    @Autowired
	AlbumDao albumDao;
	@Autowired
    UserDao userDao;
	@Autowired
	PhotoDao photoDao;

	@Test
	public void testFindByAlbum(){
		List<Photo> photos = photoDao.findByAlbum(1);
		for (Photo photo : photos) {
			System.out.println(photo.getTitle());
		}
		System.out.println("haaa");
	}
	
	@Test
	public void testFindAll() {

		List<Photo> photos = photoDao.findAll();
		for (Photo photo : photos) {
			System.out.println(photo.getTitle());
		}
		System.out.println("haaa");
    }
	

	@Test
	public void testCreate() {
		Photo photo = new Photo();
		photo.setUser(userDao.findByName("hello"));
		photo.setAlbum(albumDao.findById(1));
		photo.setTitle("p3");
		photo.setFileName("02");
		photo.setKeyword("风景");
		//photoDao.save(photo);
		System.out.println("create");

	}

	@Test
	public void testDelete() {
		Photo photo = photoDao.findByTitle("p1");
		Assert.assertNotNull(photo);
		// photoDao.delete(photo);
	}

	@Test
	public void testupdate() {
		Photo photo = photoDao.findById(3);
		photo.setTitle("p1.1");
		photo.setFileName("04");
		photo.setKeyword("汽车");
		//photoDao.update(photo);
	}

	@BeforeClass
	public static void before() {
	}

	public static void main(String[] args) {
		// 默认读取hibernate.cfg.xml文件.....

	}
}

