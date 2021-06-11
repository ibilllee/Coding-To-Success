package com.scut.cts.dto;

import com.scut.cts.pojo.Comment;
import lombok.Data;

import java.util.List;

@Data
public class CommentList
{
	private List<CommentWithAvatar> commentList;
	private int dataTotal;
	private int pageTotal;

	public CommentList(List<CommentWithAvatar> commentList, int dataTotal, int pageTotal) {
		this.commentList = commentList;
		this.dataTotal = dataTotal;
		this.pageTotal = pageTotal;
	}
}
