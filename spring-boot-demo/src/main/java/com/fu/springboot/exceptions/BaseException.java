package com.fu.springboot.exceptions;

import com.fu.springboot.util.R;

/**
 * 基础异常(其它异常的基类，其它需要异常状态码的异常继承此类)
 * 因为我们绝大多数都是运行期间发生的异常，所以继承RuntimeException，如果继承的是Exception，则每个调用的方法都要手动抛出或者try catch捕获异常。
 */
public class BaseException extends RuntimeException {
    private final Integer code;//默认基础错误状态码为1

    /**
     * 默认异常
     * @param message 错误信息
     */
    public BaseException(String message) {
        super(message);
        this.code = R.FAIL_CODE;
    }

    /**
     * 自定义异常
     * @param code 自定义异常状态码
     * @param message 自定义异常信息
     */
    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 默认异常
     * @param message 异常信息
     * @param e e
     */
    public BaseException(String message, Throwable e) {
        super(message, e);
        this.code = R.FAIL_CODE;
    }

    public BaseException(Integer code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}