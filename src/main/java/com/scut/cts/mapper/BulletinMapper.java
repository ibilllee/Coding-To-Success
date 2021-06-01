package com.scut.cts.mapper;

import com.scut.cts.pojo.Bulletin;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface BulletinMapper extends Mapper<Bulletin> {

	@Update("UPDATE bulletin SET content = #{content} WHERE bulletin_id = #{bulletinId}")
	public int updateContentByBulletinId(int bulletinId, String content);
}
