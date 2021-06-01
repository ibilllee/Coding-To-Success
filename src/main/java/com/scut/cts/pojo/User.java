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
    private boolean status;
}
