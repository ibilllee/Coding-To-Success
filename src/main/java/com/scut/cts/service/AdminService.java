package com.scut.cts.service;

import com.scut.cts.pojo.Admin;

public interface AdminService {
    public boolean login(Admin admin);
    public boolean updateAdmin(Admin admin);
}
