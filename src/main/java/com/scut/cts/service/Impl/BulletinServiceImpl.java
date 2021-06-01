package com.scut.cts.service.Impl;

import com.scut.cts.mapper.BulletinMapper;
import com.scut.cts.pojo.Bulletin;
import com.scut.cts.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulletinServiceImpl implements BulletinService {
	@Autowired
	private BulletinMapper bulletinMapper;

	@Override
	public boolean addBulletin(Bulletin bulletin) {
		return bulletinMapper.insert(bulletin)==1;
	}

	@Override
	public boolean updateBulletin(Bulletin bulletin) {
		try {
			bulletinMapper.updateContentByBulletinId(bulletin.getBulletinId(), bulletin.getContent());
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteBulletin(Bulletin bulletin) {
		return bulletinMapper.deleteByPrimaryKey(bulletin.getBulletinId())==1;
	}

	@Override
	public List<Bulletin> getAllBulletin() {
		return bulletinMapper.selectAll();
	}
}
