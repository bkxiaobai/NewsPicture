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

import com.np.dao.PhotoDao;
import com.np.dao.impl.PhotoDaoimpl;
import com.np.po.Photo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PhotoTest {
   private static PhotoDao dao;
    
    @Autowired
    ApplicationContext ctx;

	@Test
	public void testFindAll() {
		
		List<Photo> photos = getDao().findAll();
		for (Photo photo : photos) {
			System.out.println(photo.getTitle());
		}
		System.out.println("111");

	}
	
	public PhotoDao getDao() {
		return (PhotoDao)ctx.getBean("PhotoDao");
	}
	
	@Test
	public void testCreate() {
		Photo photo = new Photo();
		Date date = new Date();
		photo.setTitle("p1");
		photo.setFileName("01");
		photo.setKeyword("风景");
		getDao().save(photo);
		System.out.println("create");

	}
	
	@Test
	public void testDelete() {
		Photo photo = getDao().findByTitle("p1");
		Assert.assertNotNull(photo);
		//getDao().delete(photo);
	}
	
	@Test
	public void testupdate() {
		Photo photo = getDao().findByTitle("user-test");
		photo.setTitle("p1.1");
		photo.setFileName("02");
		photo.setKeyword("汽车");
		//getDao().update(photo);
	}
	
	
	@BeforeClass
	public static void before() {
	}
	
	public static void main(String[] args) {
		//默认读取hibernate.cfg.xml文件.....
	
	}
}

