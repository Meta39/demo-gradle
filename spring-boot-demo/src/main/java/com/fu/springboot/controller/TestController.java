package com.fu.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String hello(){
//        throw new RuntimeException("RuntimeException");//一般异常，只抛异常信息，不改变默认异常状态码
//        throw new UsernameNotFoundException();//找不到用户名异常，抛出固定异常状态码和异常信息
//        throw new MiniProgramException("小程序异常");//小程序异常，抛出固定异常状态码和自定义异常信息
        return "Hello world.";
    }

}
