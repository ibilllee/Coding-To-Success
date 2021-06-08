package com.scut.cts.mapper;

import com.scut.cts.pojo.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommentMapper extends Mapper<Comment> {

	@Select("select * from comment where comment_tuto_id = #{tutoId}")
	List<Comment> selectByTutoId(int tutoId);

	@Select("select count(*) from comment where comment_tuto_id = #{tutoId} and reply_to = #{commentId}")
	int getReplyCount(int tutoId, int commentId);

	@Update("UPDATE comment SET comment_user_id = 'CLOSED_ACCOUNT' WHERE comment_user_id = #{userId}")
	int updateToClosedAccountByUserId(String userId);

	@Delete("DELETE FROM comment WHERE comment_tuto_id = #{tutoId}")
	int deleteByTutoId(Integer tutoId);
}
