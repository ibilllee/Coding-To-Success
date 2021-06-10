package com.scut.cts.service;

import com.scut.cts.pojo.Admin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface AdminService {
    public String login(Admin admin) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    public boolean updateAdmin(Admin admin) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
