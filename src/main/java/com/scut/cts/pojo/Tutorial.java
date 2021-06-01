package com.scut.cts.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@Table(name = "tutorial")
public class Tutorial {
    @Id
    private Integer tutoId;
    private String title;
    private double titleNum;
    private String content;
    private List<Comment> commentList;
}
