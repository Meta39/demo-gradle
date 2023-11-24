package com.fu.springboot.exceptions;

/**
 * 基础异常抽象类
 * 1.其它需要异常状态码异常的继承此类，并在子类设置固定状态码。
 *      例如：UsernameNotFoundException【固定异常状态码和异常信息】；
 *          MiniProgramException【固定异常状态码，不固定异常信息】。
 * 2.不允许直接throw new BaseException
 * 3.不需要状态码的，建议直接throw new RuntimeException("异常信息")
 */
public abstract class BaseException extends RuntimeException {
    /**
     * 异常状态码
     */
    private final Integer status;

    /**
     * 自定义异常状态码和异常信息
     * @param status 自定义异常状态码
     * @param message 异常信息
     */
    public BaseException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

}
