package com.spj.miaosha.control;

import com.spj.miaosha.control.viewobject.UserVO;
import com.spj.miaosha.dataobject.UserDO;
import com.spj.miaosha.erro.BusinessException;
import com.spj.miaosha.erro.EmBusinssError;
import com.spj.miaosha.response.CommonReturnType;
import com.spj.miaosha.service.UserService;
import com.spj.miaosha.service.model.UserModel;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.ibatis.builder.BuilderException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller("user")
@CrossOrigin
@RequestMapping("user")
public class UserControl extends BaseControl {

    @Autowired
    private UserService userService;

    @Autowired HttpServletRequest httpServletRequest;


    @RequestMapping("get")
    @ResponseBody
    public CommonReturnType getUser  (@RequestParam() String id)  throws BusinessException {
        //调用service服务获取对应id的用户对象返回给前端
        UserModel userModel = userService.getUser(id);
        if (userModel == null)
            throw  new BusinessException(EmBusinssError.USER_NOTE_EXISTS);
        //将核心领域模型对象转化为供UI使用的viewObject(安全)并返回通用处理对象
        return CommonReturnType.create(convertFromModel(userModel));
    }

    public UserVO convertFromModel(UserModel userModel) {
        if ( userModel != null) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userModel, userVO);
            return  userVO;
        }
            return null;
    }

    @RequestMapping("getotp")
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name="telephone") String telephone) {
        String otp ;
        Random random = new Random();
        //生成验证码
        int vaildateCode = random.nextInt(99999);
        vaildateCode += 10000;
        //将OTP验证码同对应的用户的手机号关联，使用HTTP session的方式绑定(redis适用)
        httpServletRequest.getSession().setAttribute(telephone, vaildateCode);
        //发送给用户
        System.out.println(httpServletRequest.getSession().getAttribute(telephone));

        return CommonReturnType.create(vaildateCode);
    }

}
