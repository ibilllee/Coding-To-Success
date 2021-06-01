package com.scut.cts.service;

import com.scut.cts.pojo.Bulletin;

import java.util.List;

public interface BulletinService {
	public boolean addBulletin(Bulletin bulletin);
	public boolean updateBulletin(Bulletin bulletin);
	public boolean deleteBulletin(Bulletin bulletin);
	public List<Bulletin> getAllBulletin();
}
