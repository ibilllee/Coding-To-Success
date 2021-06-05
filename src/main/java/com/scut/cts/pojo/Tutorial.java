package com.scut.cts.pojo;

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
    private double titleNum;
    private String content;
    private List<Comment> commentList;
    private List<Problem> problemList;

    public Tutorial() {}

    public Tutorial(Integer tutoId) {
        this.tutoId = tutoId;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public void setProblemList(List<Problem> problemList) {
        this.problemList = problemList;
    }
}
