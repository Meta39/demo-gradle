package com.fu.springboot.exceptions.other;

import com.fu.springboot.exceptions.BaseException;

/**
 * 找不到用户名异常
 * 使用方法：直接 throw new UsernameNotFoundException();
 */
public class UsernameNotFoundException extends BaseException {

    public UsernameNotFoundException() {
        super(2, "找不到用户名");
    }

    public UsernameNotFoundException(Throwable e) {
        super(2, "找不到用户名", e);
    }
}
