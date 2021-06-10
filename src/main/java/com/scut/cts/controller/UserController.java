package com.scut.cts.controller;

import com.scut.cts.dto.RespBean;
import com.scut.cts.dto.Status;
import com.scut.cts.dto.StatusAndToken;
import com.scut.cts.dto.UserIdAndPassword;
import com.scut.cts.pojo.User;
import com.scut.cts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public RespBean register(@RequestParam String userId, @RequestParam String password) {
        User user = new User(userId,password);
        boolean result;
        try {
            result = userService.register(user);
        }catch (Exception e) {
            return RespBean.unprocessable("注册失败"+e.getMessage());
        }
        if(result) {
            return RespBean.created("注册成功",new Status(user.getStatus()));
        }
        return RespBean.unprocessable("注册失败");
    }

    @PostMapping("/login")
    public RespBean login(@RequestParam String userId, @RequestParam String password) {
        StatusAndToken statusAndToken ;
        User user = new User(userId, password);
        try {
            statusAndToken = userService.login(user);
        }catch (Exception e) {
            return RespBean.unprocessable("用户登录失败"+e.getMessage());
        }
        if(statusAndToken!=null) {
            return RespBean.ok("用户登录成功",statusAndToken);
        }
        return RespBean.unprocessable("用户登录失败");
    }

    @PutMapping("/{userId}")
    public RespBean updateUser(@PathVariable String userId, @RequestParam String password) {
        User user = new User(userId, password);
        boolean result;
        try {
            result = userService.updateUser(user);
        }catch (Exception e) {
            return RespBean.unprocessable("用户密码修改失败"+e.getMessage());
        }
        if(result) {
            return RespBean.ok("用户密码修改成功",new UserIdAndPassword(userId,password));
        }
        return RespBean.unprocessable("用户密码修改失败");
    }
}
