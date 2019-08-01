package com.test.jiao.service;

import com.test.jiao.bean.User;
import com.test.jiao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public boolean verify(User user) {
        if (userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean check(User user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
    public String deleteUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            userRepository.delete(user);
            return "用户名" + user.getId() + "删除成功!";
        } else {
            return "该用户不存在!";
        }
    }

//    public boolean test(User user) {
//        if (userRepository.findById(user.getId()).isPresent()) {
//            userRepository.delete(user);
//            return true;
//        } else {
//            return false;
//        }
//    }


//    public String selectUser(User user) {
//        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
//            return "该用户不存在!";
//        } else {
//            return "用户：" + user.getUsername() + "\n密码：" + user.getPassword();
//
//        }


}