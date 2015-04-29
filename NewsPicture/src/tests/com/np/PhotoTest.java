package tests.com.np;


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
	public void testCreate() {
		Photo photo = new Photo();
		photo.setTitle("p3");
		photo.setKeyword("风景");
		//photoDao.save(photo);
		System.out.println("create");

	}

	@Test
	public void testDelete() {


		// photoDao.delete(photo);
	}

	@Test
	public void testupdate() {


		//photoDao.update(photo);
	}

	@BeforeClass
	public static void before() {
	}

	public static void main(String[] args) {
		// 默认读取hibernate.cfg.xml文件.....

	}
}

