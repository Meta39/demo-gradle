package com.fu.springboot.exceptions.custom;

import com.fu.springboot.exceptions.BaseException;

/**
 * 找不到用户名异常
 * PS：如果需要和其它自定义异常区分异常信息，则需要在含有@RestControllerAdvice注解的类再加一个@ExceptionHandler
 */
public class UsernameNotFoundException extends BaseException {

    public UsernameNotFoundException() {
        super(2, "找不到用户名");
    }

}
