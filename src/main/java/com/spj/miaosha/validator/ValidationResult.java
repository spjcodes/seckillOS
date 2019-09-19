package com.spj.miaosha.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 校验结果集
 */
public class ValidationResult {

    /**
     * 校验结果
     */
    private boolean hasErros = false;
    /**
     * 错误信息
     */
    private Map<String,String> erroMsgMap = new HashMap<String, String>();


    public boolean isHasErros() {
        return hasErros;
    }

    public void setHasErros(boolean hasErros) {
        this.hasErros = hasErros;
    }

    public Map<String,String> getErroMsgMap(){
        return erroMsgMap;
    }

    public String getErroMsg() {
        return StringUtils.join(erroMsgMap.values().toArray(),",");
    }



    public void setErroMsgMap(Map<String, String> erroMsgMap) {
        this.erroMsgMap = erroMsgMap;
    }


}
