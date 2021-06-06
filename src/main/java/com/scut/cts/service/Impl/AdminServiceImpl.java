package com.scut.cts.service.Impl;

import com.scut.cts.mapper.AdminMapper;
import com.scut.cts.pojo.Admin;
import com.scut.cts.service.AdminService;
import com.scut.cts.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean login(Admin admin) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        admin.setPassword(MD5Utils.EncoderByMd5(admin.getPassword()));
        Admin result = adminMapper.selectOne(admin);
        if(result == null)return false;
        return true;
    }

    @Override
    public boolean updateAdmin(Admin admin) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        admin.setPassword(MD5Utils.EncoderByMd5(admin.getPassword()));
        return adminMapper.updateByPrimaryKeySelective(admin)==1;
    }
}
