package com.wei.itexpdf.common;

public enum ResponseEnum {
    /** 成功 */
    SUCCESS(0,"成功"),
    /** 失败 */
    ERROR(-1,"失败");


    private Integer code;
    private String msg;

    //构造方法
    private ResponseEnum(Integer code,String msg ){
        this.code = code;
        this.msg = msg;
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
}
