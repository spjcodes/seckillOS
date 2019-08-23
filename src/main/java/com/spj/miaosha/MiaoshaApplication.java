package com.spj.miaosha;

import com.spj.miaosha.dao.UserDOMapper;
import com.spj.miaosha.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = {"com.spj.miaosha"})
@MapperScan("com.spj.miaosha.dao")
public class MiaoshaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiaoshaApplication.class, args);
    }

    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String getUserdo() {
        UserDO user = userDOMapper.selectUserDo("2");
        if (user == null) {
            return "用户对象不存在";
        }

        return user.getName();
    }

}
