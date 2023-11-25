package com.fu.springboot.exceptions;

/**
 * 401 未认证异常
 */
public class UnauthorizedException extends RuntimeException {
    /**
     * 默认异常信息
     */
    public UnauthorizedException() {
        super("抱歉，请先登录认证后再访问！");
    }

    /**
     * 自定义 unauthorized 异常信息
     * @param message 自定义异常信息
     */
    public UnauthorizedException(String message) {
        super(message);
    }

}
