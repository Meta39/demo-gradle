package com.fu.springboot.exceptions.custom;

/**
 * 微信小程序异常（自定义异常信息）
 */
public class MiniProgramException extends RuntimeException {
    public MiniProgramException(String message) {
        super(message);
    }
}
