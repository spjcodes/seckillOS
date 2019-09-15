package com.spj.miaosha.service;

import com.spj.miaosha.service.model.UserModel;

public interface UserService {

    public UserModel getUser(String id);
    public boolean addUser(UserModel userModel);
    public boolean deleteUser(String id);

}
