package com.spj.miaosha.control;

import com.spj.miaosha.control.viewobject.UserVO;
import com.spj.miaosha.erro.BusinessException;
import com.spj.miaosha.erro.EmBusinssError;
import com.spj.miaosha.response.CommonReturnType;
import com.spj.miaosha.service.UserService;
import com.spj.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@Controller("user")
@CrossOrigin()
@RequestMapping("user")
public class UserControl extends BaseControl {

    @Autowired
    private  UserService userService;

   @Autowired
    private HttpServletRequest httpServletRequest;


    @RequestMapping("register")
    @ResponseBody
    public CommonReturnType register(@RequestBody UserVO userVO) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        //验证码校验
       /* String inSessionOtpCode = (String) httpServletRequest.getSession().getAttribute("telephone");
        System.out.println("get session info");
        System.out.println(inSessionOtpCode);
        if(!StringUtils.equals(userVO.getVarificationCode(),inSessionOtpCode))
            throw new BusinessException(EmBusinssError.VERIFICATION_CODE_ERRO);*/

        //用户注册
        if(userVO == null)
            throw new BusinessException(EmBusinssError.USER_NOTE_EXISTS);
        UserModel userModel = this.convertFormUservo(userVO);
        userService.addUser(userModel);
        return CommonReturnType.create(userModel);
    }

    private UserModel convertFormUservo(UserVO userVO) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException {
        if (userVO == null )
            return null;
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userVO, userModel);
        //加密密码字段
        userModel.setEncrptPassword(encoderByMD5(userVO.getEncrpt_password()));
        return userModel;
    }

    //敏感信息字段加密
    private String encoderByMD5(String encrpt_password) throws NoSuchAlgorithmException, UnsupportedEncodingException, BusinessException {
        if(encrpt_password == null)
            throw new BusinessException(EmBusinssError.PARAMTER_NOT_VALID.setErrMsg("无效的密码"));
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encryptedStr = base64Encoder.encode(md5.digest(encrpt_password.getBytes("utf-8")));
        return encryptedStr;
    }


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
        System.out.println("put session info");
        System.out.println(httpServletRequest.getSession().getAttribute(telephone));
        return CommonReturnType.create(vaildateCode);
    }

}
