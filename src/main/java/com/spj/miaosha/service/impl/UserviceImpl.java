package com.spj.miaosha.service.impl;

import com.spj.miaosha.dao.UserDOMapper;
import com.spj.miaosha.dao.UserPasswordDOMapper;
import com.spj.miaosha.dataobject.UserDO;
import com.spj.miaosha.dataobject.UserPasswordDO;
import com.spj.miaosha.erro.BusinessException;
import com.spj.miaosha.erro.EmBusinssError;
import com.spj.miaosha.service.UserService;
import com.spj.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserviceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired

    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUser(String id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        if (userDO == null)
            return null;
        //通过用户id获取对应的加密密码信息
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserid(userDO.getId());
        return convertFromDataObject(userDO, userPasswordDO);
    }

    @Override
    public boolean addUser(UserModel userModel) {
        if (userModel == null)
            return false;
        UserDO userDo = this.convertFromUserModel(userModel);
        userDo.setThirdPartyId("1312554");
        userDOMapper.insertSelective(userDo);
        UserPasswordDO userPasswordDO = this.convertFormUserModel(userModel);
        userPasswordDOMapper.insertSelective(userPasswordDO);
        return true;
    }

    public UserDO convertFromUserModel(UserModel usermodel) {

        if (usermodel == null)
            return null;
        UserDO userDo = new UserDO();
        BeanUtils.copyProperties(usermodel, userDo);
        return userDo;
    }

    public UserPasswordDO
    convertFormUserModel (UserModel userModel) {
        if (userModel.getEncrptPassword() != null ) {
            UserPasswordDO  userPasswordDO = new UserPasswordDO();
            userPasswordDO.setUserId(userModel.getId());
            userPasswordDO.setEncrptPassword(userModel.getEncrptPassword());
            return userPasswordDO;
        }
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }

    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO) {

        if (userDO == null )
            return null;

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);

        if (userPasswordDO != null)
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());

        return userModel;
    }
}

