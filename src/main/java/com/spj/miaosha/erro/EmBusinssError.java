package com.spj.miaosha.erro;

public enum EmBusinssError implements CommonError{
    //10000 用户相关
    USER_NOTE_EXISTS(10001,"用户不存在"),
    //20000 通用错误类型
    PARAMTER_NOT_VALID(20001, "差数不合法"),
    UNKONW_ERRO(20002, "未知错误"),
    ;

    private int errCode;
    private String errMsg;

    EmBusinssError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return errCode;
    }

    @Override
    public String getErrMsg() {
        return errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
