package com.lk.sc.entity;


import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author likeLove
 * @time 2020-08-30  10:58
 */
@Data
public class Result {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<String, Object>();


    public Result() {
    }

    public static Result ok() {
        Result result = new Result();
        result.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        result.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        result.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        return result;
    }

    public Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    @Getter
    @ToString
    enum ResultCodeEnum {

        /**
         * 成功
         */
        SUCCESS(true, 20000, "成功"),
        /**
         * 失败
         */
        UNKNOWN_REASON(false, 20001, "未知错误");

        private Boolean success;

        private Integer code;

        private String message;


        ResultCodeEnum(Boolean success, Integer code, String message) {
            this.success = success;
            this.code = code;
            this.message = message;
        }

    }
}

