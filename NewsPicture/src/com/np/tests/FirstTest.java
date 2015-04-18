package com.np.tests;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import com.np.dao.UserDao;
import com.np.dao.impl.UserDaoimpl;
import com.np.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class FirstTest {
    private static UserDao dao;
    
    @Autowired
    ApplicationContext ctx;

	@Test
	public void testFindAll() {
		
		List<User> users = getDao().findAll();
		for (User user : users) {
			System.out.println(user.getUserame());
		}
		System.out.println("haaa");

	}
	
	public UserDao getDao() {
		return (UserDao)ctx.getBean("UserDao");
	}
	
	@Test
	public void testCreate() {
		User user = new User();
		Date date = new Date();
		user.setUsername("test");
		user.setPassword("mypass");
		getDao().save(user);
		System.out.println("create");

	}
	
	@Test
	public void testDelete() {
		User user = getDao().findByName("test");
		Assert.assertNotNull(user);
		getDao().delete(user);
	}
	
	
	@BeforeClass
	public static void before() {
	}
	
	public static void main(String[] args) {
		//默认读取hibernate.cfg.xml文件.....
	
	}
}
