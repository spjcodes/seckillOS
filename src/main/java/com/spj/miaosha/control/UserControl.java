package com.spj.miaosha.control;

import com.spj.miaosha.control.viewobject.UserVO;
import com.spj.miaosha.dataobject.UserDO;
import com.spj.miaosha.service.UserService;
import com.spj.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("user")
@RequestMapping("/user")
public class UserControl {

    @Autowired
    private UserService userService;



    @RequestMapping("/get")
    @ResponseBody
    public UserVO getUser(@RequestParam() String id) {
        //调用service服务获取对应id的用户对象返回给前端
        UserModel userModel = userService.getUser("1");
        //将核心领域模型对象转化为供UI使用的viewObject(安全)
        return convertFromModel(userModel);
    }

    public UserVO convertFromModel(UserModel userModel) {
        if ( userModel != null) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userModel, userVO);
            return  userVO;
        }

        return  null;
    }

}
