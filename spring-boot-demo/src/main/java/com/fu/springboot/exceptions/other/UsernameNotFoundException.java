package com.fu.springboot.exceptions.other;

import com.fu.springboot.exceptions.BaseException;

/**
 * 找不到用户名异常
 */
public class UsernameNotFoundException extends BaseException {

    /**
     * 默认异常信息
     */
    public UsernameNotFoundException() {
        super(2, "找不到用户名");
    }

    /**
     * 自定义找不到用户名异常信息
     * @param message 自定义异常信息
     */
    public UsernameNotFoundException(String message) {
        super(2, message);
    }
}
