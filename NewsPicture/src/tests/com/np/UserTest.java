package tests.com.np;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.np.dao.UserDao;
import com.np.po.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserTest {

	@Autowired
	UserDao userDao;




	@Test
	public void test1Create() {
		User user = new User(null, null);
		user.setUsername("bkxiao");
		user.setPassword("456");
		userDao.save(user);
		System.out.println("create");

	}


	@Test
	public void test2Update() {
		User user = userDao.findByName("bkxiao");
		user.setPassword("1992");
		userDao.update(user);
	}
	
	@Test
	public void test3Delete() {
		User user = userDao.findByName("bkxiao");
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
