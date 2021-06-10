package com.scut.cts.service.Impl;

import com.scut.cts.dto.CommentWithAvatar;
import com.scut.cts.pojo.Comment;
import com.scut.cts.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {
	@Autowired
	private CommentService commentService;

	@Test
	public void addComment(){
		Comment comment1 = new Comment(1,"user","内容",null,null);
		Comment comment2 = new Comment(1,"user","内容",1,commentService.getReplyCount(1,1)+1);
		commentService.addComment(comment1);
		commentService.addComment(comment2);
	}

	@Test
	public void getComment(){
		List<CommentWithAvatar> comments = commentService.getComments(1);
		System.out.println(comments);
	}
}