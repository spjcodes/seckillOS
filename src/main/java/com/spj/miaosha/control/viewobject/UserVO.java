package com.spj.miaosha.control.viewobject;

import lombok.Data;

@Data
public class UserVO {
    private String id;

    private String name;

    private String encrpt_password;

    private String varificationCode;

    private Boolean gender;

    private Integer age;

    private String telephone;

    private String registerMode;

}
