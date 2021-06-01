package com.scut.cts.mapper;

import com.scut.cts.pojo.Bulletin;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface BulletinMapper extends Mapper<Bulletin> {

	@Select("UPDATE bulletin SET content = #{content} WHERE bulletin_id = #{bulletinId}")
	public void updateContentByBulletinId(int bulletinId,String content);
}
