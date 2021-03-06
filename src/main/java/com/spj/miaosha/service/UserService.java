package com.spj.miaosha.service;

import com.spj.miaosha.erro.BusinessException;
import com.spj.miaosha.service.model.UserModel;

public interface UserService {

    public UserModel getUser(String id);
    public boolean addUser(UserModel userModel) throws BusinessException;
    public boolean deleteUser(String id);
    public UserModel validateLoginByUserName(String username, String password) throws BusinessException;
    public UserModel validateLoginByTelephone(String telephone, String password) throws BusinessException;

}
