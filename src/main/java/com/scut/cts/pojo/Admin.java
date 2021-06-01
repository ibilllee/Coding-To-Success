package com.scut.cts.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "admin")
public class Admin {
    @Id
    private String adminId;
    private String password;
}
