package com.fu.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String hello(){
//        throw new UsernameNotFoundException();//抛出自定义状态码异常并记录到日志
//        throw new CheckException("不能为空");//直接返回给前端，不会记录到输出日志到控制台/文件的自定义的异常
        return "Hello world.";
    }

}
