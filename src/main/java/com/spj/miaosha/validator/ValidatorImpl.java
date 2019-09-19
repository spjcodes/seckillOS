package com.spj.miaosha.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidatorImpl implements InitializingBean {

    private Validator validator;
    public ValidationResult validate(Object bean) {

        ValidationResult result = new ValidationResult();
        //错误结果集
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);
        if (constraintViolationSet.size() > 0) {
            constraintViolationSet.forEach(constraintViolation -> {
                result.setHasErros(true);
                String erroMsg = constraintViolation.getMessage();
                String paramName = constraintViolation.getPropertyPath().toString();
                result.getErroMsgMap().put(paramName, erroMsg);
            });
        }
        return result;
    }

    //spring 初始化完成后回调afterPeopertiesSet()方法
    @Override
    public void afterPropertiesSet() throws Exception {
        // 将hibernate validator通过工厂的初始化方式使其实例化
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
}
