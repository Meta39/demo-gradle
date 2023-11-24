package com.fu.springboot.exceptions.custom;

import com.fu.springboot.exceptions.BaseException;

/**
 * 微信小程序异常
 * PS：如果需要和其它自定义异常区分异常信息，则需要在含有@RestControllerAdvice注解的类再加一个@ExceptionHandler
 */
public class MiniProgramException extends BaseException {

    /**
     * 返回给小程序的异常信息
     * @param message 小程序异常信息异常信息
     */
    public MiniProgramException(String message) {
        super(10, message);
    }
}
