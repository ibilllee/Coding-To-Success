package com.scut.cts.service;

import com.scut.cts.pojo.Bulletin;

import java.util.List;

public interface BulletinService {
	boolean addBulletin(Bulletin bulletin);
	boolean updateBulletin(Bulletin bulletin);
	boolean deleteBulletin(Bulletin bulletin);
	List<Bulletin> getAllBulletin();
}
