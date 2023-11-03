package com.fu.springboot.util;

import com.fu.springboot.exceptions.BaseException;

/**
 * 基础工具类
 */
public abstract class R {
    public static final Integer SUCCESS_CODE = 0;//默认成功状态码
    public static final String SUCCESS_MESSAGE = "success";//默认成功信息

    public static final Integer FAIL_CODE = 1;//默认失败状态码
    //------------------------------- 返回 ----------------------------------

    /**
     * 默认返回
     *
     * @param data 成功返回的数据
     */
    public static <T> Res<?> res(T data) {
        return R.res(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    /**
     * 返回（前端不要求返回信息不要用）
     *
     * @param messgae 成功信息
     * @param data    成功返回的数据
     */
    public static <T> Res<?> res(String messgae, T data) {
        return R.res(SUCCESS_CODE, messgae, data);
    }

    /**
     * 返回（前端不要求返回信息不要用）
     *
     * @param code 状态码
     * @param data 成功返回的数据
     */
    public static <T> Res<?> res(Integer code, T data) {
        return R.res(code, SUCCESS_MESSAGE, data);
    }

    /**
     * 返回(基础)
     *
     * @param code    状态码
     * @param messgae 信息
     * @param data    成功返回的数据
     */
    public static <T> Res<?> res(Integer code, String messgae, T data) {
        return new Res<>(code, messgae, data);
    }

    //------------------------------- 自定义异常 ----------------------------------

    /**
     * 默认异常
     *
     * @param messsage 异常信息
     */
    public static void err(String messsage) {
        R.err(FAIL_CODE,messsage, null);
    }

    /**
     * 默认异常
     *
     * @param messsage 异常信息
     * @param e        e
     */
    public static void err(String messsage, Throwable e) {
        R.err(FAIL_CODE,messsage, e);
    }

    /**
     * 自定义异常
     *
     * @param code     错误状态码
     * @param messsage 异常信息
     */
    public static void err(Integer code, String messsage) {
        R.err(code,messsage, null);
    }

    /**
     * 自定义异常(基础)
     *
     * @param code     错误状态码
     * @param messsage 异常信息
     */
    public static void err(Integer code, String messsage, Throwable e) {
        throw new BaseException(code, messsage, e);
    }

}