package com.fu.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String hello(@RequestParam("param") String param) throws Exception {
//        throw new Exception("Exception");//非运行时异常，不需要状态码区分。
//        throw new RuntimeException("RuntimeException");//一般运行时异常，不需要状态码区分。
//        throw new UnauthorizedException();//特殊异常，未认证异常，需要其它异常状态码区分。
//        throw new ForbiddenException();//特殊异常，未鉴权异常，需要其它异常状态码区分。
//        throw new MiniProgramException("小程序异常");//小程序异常，不需要状态码区分，但是需要区分异常类
        String name = Thread.currentThread().getName();
        log.info("name:{}", name);
        log.info("param:{}", param);
        return param;
    }

    @PostMapping
    public String post(@RequestHeader("Accept-Charset") String acceptCharset,
                       @RequestHeader("zdy") String zdy,
                       @RequestParam("param") String param,
                       @RequestBody String requestBody) {
        log.info("acceptCharset:{}", acceptCharset);
        log.info("zdy:{}", zdy);
        log.info("param:{}", param);
        log.info("requestBody:{}", requestBody);
        return "POST 请求响应";
    }

}
