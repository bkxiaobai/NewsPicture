package tests.com.np;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.np.dao.UserDao;
import com.np.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserTest {

	@Autowired
	UserDao userDao;




	@Test
	public void testCreate() {
		User user = new User(null, null);
		user.setUsername("bkxiaobai");
		user.setPassword("456");
		userDao.save(user);
		System.out.println("create");

	}


	@Test
	public void testupdate() {
		User user = userDao.findByName("usertest");
		user.setPassword("1992");
		userDao.update(user);
	}
	
	@Test
	public void testDelete() {
		User user = userDao.findByName("hello");
		Assert.assertNotNull(user);
		userDao.delete(user);
	}


	@BeforeClass
	public static void before() {
	}

	public static void main(String[] args) {
		// 默认读取hibernate.cfg.xml文件.....

	}
}
