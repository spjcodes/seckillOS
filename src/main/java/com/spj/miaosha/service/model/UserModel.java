package com.spj.miaosha.service.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * 业务逻辑的核心模型
 */
@Data
public class UserModel {

    private String id;

    @NotBlank(message = "昵称不能为空")
    private String name;

    private Boolean gender;

    @NotNull
    @Min(0)
    @Max(150)
    private Integer age;

    @NotNull(message = "手机号不能为空")
//    @Pattern(regexp = "/^1([38]\\d|5[0-35-9]|7[3678])\\d{8}$/",message = "手机号不合法")
    @Length(min = 11,max = 11,message = "手机号应该为十一位的数字字符串")
    private String telephone;

    private String registerMode;

    private String thirdPartyId;

    @NotBlank(message = "密码不能为空")
//    @Length(min = 8,max = 16,message = "密码长度不能少于8位或者大于16位")
    private String encrptPassword;
}
