package com.fu.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String hello(){
//        throw new UsernameNotFoundException();//直接抛出自定义异常（这个异常会记录到日志）
//        throw new CheckException("不能为空");//直接返回给前端，不需要记录到输出日志到控制台/文件的自由的异常
        return "Hello world.";
    }

}
