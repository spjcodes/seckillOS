package com.spj.miaosha.response;

/**
 * @author: www.jiayeli.cn
 * 通用返回格式
 */
public class CommonReturnType {

    private String status;
    private Object data;

    public String getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result, "successful");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setData(result);
        commonReturnType.setStatus(status);
        return commonReturnType;
    }


    }
