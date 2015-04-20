package tests.com.np;

import java.util.List;

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
	public void testFindAll() {

		List<User> users = userDao.findAll();
		for (User user : users) {
			System.out.println(user.getUsername());
		}
		System.out.println("haaa");

	}

	@Test
	public void testCreate() {
		User user = new User();
		user.setUsername("user-test");
		user.setPassword("456");
		userDao.save(user);
		System.out.println("create");

	}


	@Test
	public void testupdate() {
		User user = userDao.findByName("usertest");
		user.setPassword("123");
		userDao.update(user);
	}
	
	@Test
	public void testDelete() {
		User user = userDao.findByName("user-test");
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
