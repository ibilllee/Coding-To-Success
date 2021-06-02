package com.scut.cts.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "problem")
public class Problem {
    @Id
    private Integer probId;
    private Integer probTutoId;
    private String content;
}