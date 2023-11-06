package com.fu.springboot.exceptions;

/**
 * 直接返回给前端，不需要记录到输出日志到控制台/文件的异常
 * 例如：校验异常（XXX不能为空，直接返回给前端，不进行记录日志到控制台或者文件。）
 */
public class NotLogException extends BaseException {

    public NotLogException(String message) {
        super(message);
    }

}