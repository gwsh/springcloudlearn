package com.gwsh.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("RESTful通用实体")
public class RestResult<T> {

    /**
     * uuid,用作唯一标识符，供序列化和反序列化时检测是否一致
     */
    private static final long    serialVersionUID = 7498483649536881777L;
    /**
     * 标识代码，0表示失败，非0表示成功
     */
    @ApiModelProperty("标识代码，0表示失败，非0表示成功")
    private              Integer code;

    /**
     * 提示信息，通常供报错时使用
     */
    @ApiModelProperty("提示信息,供报错时使用")
    private String msg;

    /**
     * 正常返回时返回的数据
     */
    @ApiModelProperty("返回的数据")
    private T data;

    /**
     * constructor
     */
    public RestResult() {
    }

    public RestResult(Integer status, String msg, T data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回成功数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult success(T data) {
        return new RestResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
    }

    /**
     * @param code
     * @param msg
     * @return
     */
    public static RestResult success(Integer code, String msg) {
        return new RestResult(code, msg, null);
    }

    /**
     * 返回出错数据
     *
     * @param code
     * @return
     */
    public static RestResult error(ResponseCode code) {
        return new RestResult(code.getCode(), code.getMsg(), null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}

/**
 * 状态枚举类
 */
enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(1, "成功"),

    /**
     * 失败
     */
    ERROR(0, "失败"),


    /**
     * 参数错误
     */
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT"),


    /**
     * token 无效
     */
    TOKEN_INVALID(16, "token_invalid");

    /**
     * 状态码
     */
    private final int    code;
    /**
     * 与状态码相对应的描述
     */
    private final String msg;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.msg = desc;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}