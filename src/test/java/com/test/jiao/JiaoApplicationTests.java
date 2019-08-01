package com.test.jiao;

import com.test.jiao.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JiaoApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void contextLoads() {
        System.err.println("---------------------------");
        System.err.println(userRepository.findByUsername("jwen").get(0).getUsername());
        if (userRepository.findByUsername("jwen").isEmpty()) {

            System.out.println("用户名注册成功!");
        } else {
            System.out.println("用户名已被占用!");
        }
    }
}

