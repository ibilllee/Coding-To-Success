package com.scut.cts.service.Impl;

import com.scut.cts.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTest {
    @Autowired
    private AdminServiceImpl adminService;

    @Test
    public void login() {
        System.out.println(adminService.login(new Admin("admin","admin")));
    }

    @Test
    public void updateAdmin() {
        System.out.println(adminService.updateAdmin(new Admin("admin","123456")));
    }
}
