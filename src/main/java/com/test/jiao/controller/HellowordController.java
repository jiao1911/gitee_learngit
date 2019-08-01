package com.test.jiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HellowordController {
    @GetMapping(value = "/helloworld")
    public String helloworld(){
        return "helloworld";
    }
}
