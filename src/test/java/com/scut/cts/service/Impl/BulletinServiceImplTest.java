package com.scut.cts.service.Impl;

import com.scut.cts.pojo.Bulletin;
import com.scut.cts.service.BulletinService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BulletinServiceImplTest {
	@Autowired
	private BulletinService bulletinService;

	@Test
	public void addBulletin(){
		bulletinService.addBulletin(new Bulletin("公告"));
	}

	@Test
	public void updateBulletin() {
		bulletinService.updateBulletin(new Bulletin(2,"改了的公告"));
	}

	@Test
	public void deleteBulletin(){
		bulletinService.deleteBulletin(new Bulletin(1,""));
	}

	@Test
	public void getAllBulletin(){
		System.out.println(bulletinService.getAllBulletin());
	}
}