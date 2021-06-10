package com.scut.cts.pojo;

import com.scut.cts.dto.CommentWithAvatar;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@Table(name = "tutorial")
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tutoId;
    private String titleContent;
    private Double titleNum;
    private String content;
    private List<CommentWithAvatar> commentList;
    private List<Problem> problemList;

    public Tutorial() {}

    public Tutorial(Integer tutoId) {
        this.tutoId = tutoId;
    }

    public Tutorial(Integer tutoId, String content) {
        this.tutoId = tutoId;
        this.content = content;
    }

    public Tutorial(String titleContent, String content, double titleNum) {
        this.titleContent = titleContent;
        this.content = content;
        this.titleNum = titleNum;
    }

    public void setCommentList(List<CommentWithAvatar> commentList) {
        this.commentList = commentList;
    }

    public void setProblemList(List<Problem> problemList) {
        this.problemList = problemList;
    }
}
