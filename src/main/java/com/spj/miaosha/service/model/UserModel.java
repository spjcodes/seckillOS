package com.spj.miaosha.service.model;

import lombok.Data;

/**
 * 业务逻辑的核心模型
 */
@Data
public class UserModel {

    private String id;

    private String name;

    private Boolean gender;

    private Integer age;

    private String telephone;

    private String registerMode;

    private String thirdPartyId;

    private String encrptPassword;
}
