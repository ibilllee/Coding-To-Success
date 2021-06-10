package com.scut.cts.dto;

import com.scut.cts.pojo.Bulletin;
import lombok.Data;

import java.util.List;

@Data
public class BulletinList{
	private List<Bulletin> bulletinList;

	public BulletinList(List<Bulletin> bulletinList) {
		this.bulletinList = bulletinList;
	}
}
