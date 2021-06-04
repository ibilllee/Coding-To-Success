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

    public Admin() {}

    public Admin(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
    }
}
