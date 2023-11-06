package com.fu.springboot.exceptions;


import com.fu.springboot.global.Res;

/**
 * 基础异常(其它异常的基类，其它需要异常状态码的异常继承此类)
 * 因为我们绝大多数都是运行期间发生的异常，所以继承RuntimeException，如果继承的是Exception，则每个调用的方法都要手动抛出或者try catch捕获异常。
 */
public class BaseException extends RuntimeException {
    private final Integer code;//默认基础错误状态码为1

    /**
     * 默认异常：允许直接抛出此异常，即：不允许直接 throw new BaseException(message);
     * @param message 错误信息
     */
    public BaseException(String message) {
        super(message);
        this.code = Res.DEFAULT_FAIL_CODE;
    }

    /**
     * 自定义异常（例子：UsernameNotFoundException）
     * 受保护的方法，只允许子类使用！禁止改成public！
     * 不允许直接 throw new BaseException(code, message) 而应该单独定义一个Exception类继承 BaseException() 然后抛出定义的异常类！
     * @param code 自定义异常状态码
     * @param message 自定义异常信息
     */
    protected BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}