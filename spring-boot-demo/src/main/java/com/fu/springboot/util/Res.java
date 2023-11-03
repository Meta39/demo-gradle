package com.fu.springboot.util;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * 统一返回类
 */
public class Res<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 6558796578827818466L;

    private Integer code; //成功或异常状态码（成功默认为0，失败默认为1）

    private String messgae; //成功信息或异常信息

    private T data; //数据（失败默认返回null）

    //---------------------------------------- 成功 --------------------------------------------------------

    /**
     * @param code    状态码（无特殊情况，成功默认为0，失败默认为1）
     * @param messgae 成功/失败信息
     * @param data    成功返回的数据（失败默认返回null）
     */
    public Res(Integer code, String messgae, T data) {
        this.code = code;
        this.messgae = messgae;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Res{" +
                "code=" + code +
                ", msg='" + messgae + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Res<?> res = (Res<?>) o;
        return Objects.equals(code, res.code) && Objects.equals(messgae, res.messgae) && Objects.equals(data, res.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, messgae, data);
    }

}