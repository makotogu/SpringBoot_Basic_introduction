package com.example.springbootmybatis;

import com.example.springbootmybatis.domain.User;
import com.example.springbootmybatis.mapper.UserMapper;
import com.example.springbootmybatis.mapper.UserXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMyBatisApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserXmlMapper userXmlMapper;

    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }
    @Test
    public void testFindAll2() {
        List<User> userList = userXmlMapper.findAll();
        System.out.println(userList);
    }


}
