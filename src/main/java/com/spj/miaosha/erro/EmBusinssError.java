package com.spj.miaosha.erro;

public enum EmBusinssError implements CommonError{
    //10000 用户相关
    USER_NOTE_EXISTS(10001,"用户不存在"),
    //20000
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
