package com.scut.cts.mapper;

import com.scut.cts.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void insert(){
		userMapper.insert(new User("username","password",1));
	}

	@Test
	public void selectOne(){
		System.out.println(userMapper.selectOne(new User("username","password")));
	}

	@Test
	public void update(){
		System.out.println(userMapper.updateByPrimaryKeySelective(new User("username",null,0)));
	}

	@Test
	public void delete(){
		userMapper.delete(new User("username","password",userMapper.selectStatusByUserId("username")));
	}
}