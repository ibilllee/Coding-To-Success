package com.scut.cts.service.Impl;

import com.scut.cts.mapper.AdminMapper;
import com.scut.cts.pojo.Admin;
import com.scut.cts.service.AdminService;
import com.scut.cts.utils.MD5Utils;
import com.scut.cts.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String login(Admin admin) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String password = admin.getPassword();
        admin.setPassword(MD5Utils.encodeByMd5(admin.getPassword()));
        Admin result = adminMapper.selectOne(admin);
        if(result == null) return null;
        return TokenUtils.getToken(admin.getAdminId(),password);
    }

    @Override
    public boolean updateAdmin(Admin admin) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        admin.setPassword(MD5Utils.encodeByMd5(admin.getPassword()));
        return adminMapper.updateByPrimaryKeySelective(admin)==1;
    }
}
