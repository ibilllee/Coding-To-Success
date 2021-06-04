package com.scut.cts.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "user")
public class User {
    @Id
    private String userId;
    private String password;
    private Integer status=1;

    public User(String password) {
        this.password = password;
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User(String userId, String password, int status) {
        this.userId = userId;
        this.password = password;
        this.status = status;
    }
}
