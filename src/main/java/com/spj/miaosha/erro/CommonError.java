package com.spj.miaosha.erro;

/**
 * @author www.jiayeli.cn
 */
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}
