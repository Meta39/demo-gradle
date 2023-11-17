package com.fu.springboot.exceptions;

/**
 * 找不到用户名异常
 */
public class UsernameNotFoundException extends RuntimeException {
    public static final Integer CODE = 2;

    public UsernameNotFoundException() {
        super("找不到用户名");
    }

}
