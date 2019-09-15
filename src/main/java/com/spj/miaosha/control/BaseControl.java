package com.spj.miaosha.control;

import com.spj.miaosha.erro.BusinessException;
import com.spj.miaosha.erro.EmBusinssError;
import com.spj.miaosha.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseControl {

    //自定义异常 处理未被conreol层吸收的Exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(HttpServletRequest request, Exception e) {

        CommonReturnType commonReturnType  = new CommonReturnType();
        Map m = new HashMap();

        if(e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            commonReturnType.setStatus("fail");
            commonReturnType.setData(e);
            m.put("erroCode",businessException.getErrCode());
            m.put("erroMsg", businessException.getErrMsg());
        } else {
            m.put("erroCode", EmBusinssError.UNKONW_ERRO.getErrCode());
            m.put("erroMsg", EmBusinssError.UNKONW_ERRO.getErrMsg());
        }
        return m;
    }
}
