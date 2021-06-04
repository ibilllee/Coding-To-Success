package com.scut.cts.service.Impl;

import com.scut.cts.mapper.AdminMapper;
import com.scut.cts.pojo.Admin;
import com.scut.cts.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean login(Admin admin) {
        Admin result = adminMapper.selectOne(admin);
        if(result == null)return false;
        return true;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin)==1;
    }
}
