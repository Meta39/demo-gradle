package com.fu.springboot.exceptions;

/**
 * 鉴权异常
 * 即调用接口时，不具备权限。
 */
public class ForbiddenException extends RuntimeException {
    public ForbiddenException() {
        super("抱歉，您没有权限访问，请向管理员申请权限！");
    }

    public ForbiddenException(String message) {
        super(message);
    }

}
