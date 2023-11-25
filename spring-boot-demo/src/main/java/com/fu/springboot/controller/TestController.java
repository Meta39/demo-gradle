package com.fu.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String hello() throws Exception {
//        throw new Exception("Exception");//非运行时异常，不需要状态码区分。
//        throw new RuntimeException("RuntimeException");//一般运行时异常，不需要状态码区分。
//        throw new UnauthorizedException();//特殊异常，未认证异常，需要其它异常状态码区分。
//        throw new ForbiddenException();//特殊异常，未鉴权异常，需要其它异常状态码区分。
//        throw new MiniProgramException("小程序异常");//小程序异常，不需要状态码区分，但是需要区分异常类
        return "Hello world.";
    }

}
