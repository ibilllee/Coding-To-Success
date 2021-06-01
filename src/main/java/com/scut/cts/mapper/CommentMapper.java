package com.scut.cts.mapper;

import com.scut.cts.pojo.Comment;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommentMapper extends Mapper<Comment> {

	@Select("select * from comment where comment_tuto_id = #{tutoId}")
	public List<Comment> selectByTutoId(int tutoId);

	@Select("select count(*) from comment where comment_tuto_id = #{tutoId} and reply_to = #{commentId}")
	public int getReplyCount(int tutoId, int commentId);
}
