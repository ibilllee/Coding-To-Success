package com.scut.cts.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "problem")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer probId;
    private Integer probTutoId;
    private String content;

    public Problem() {}

    public Problem(Integer probId) {
        this.probId = probId;
    }

    public Problem(String content) {
        this.content = content;
    }

    public Problem(Integer probTutoId, String content) {
        this.probTutoId = probTutoId;
        this.content = content;
    }

    public Problem(Integer probId, Integer probTutoId, String content) {
        this.probId = probId;
        this.probTutoId = probTutoId;
        this.content = content;
    }
}
