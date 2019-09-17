package com.spj.miaosha.service.impl;

import com.spj.miaosha.dao.UserDOMapper;
import com.spj.miaosha.dao.UserPasswordDOMapper;
import com.spj.miaosha.dataobject.UserDO;
import com.spj.miaosha.dataobject.UserPasswordDO;
import com.spj.miaosha.erro.BusinessException;
import com.spj.miaosha.erro.EmBusinssError;
import com.spj.miaosha.service.UserService;
import com.spj.miaosha.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public UserModel validateLoginByUserName(String username, String password) throws BusinessException {
        UserDO userDO = new UserDO();
        UserPasswordDO passwordDO = new UserPasswordDO();
        userDO = userDOMapper.selectByName(username);
        if (userDO == null)
            throw new BusinessException(EmBusinssError.USER_LOGIN_FAILD);
        passwordDO = userPasswordDOMapper.selectByPassword(password);
        if(userDO.getName() == null || passwordDO.getEncrptPassword() == null)
            throw new BusinessException(EmBusinssError.USERNAMW_OR_PASSwoRD_ERRO);
        if (StringUtils.equals(userDO.getName(),username))
            if (StringUtils.equals(passwordDO.getEncrptPassword(),password))
                return convertFromDataObject(userDO, passwordDO);
        return null;
    }

    @Override
    public UserModel validateLoginByTelephone(String telephone, String encrpe_password) throws BusinessException {
        UserDO userDO = new UserDO();
        UserPasswordDO passwordDO = new UserPasswordDO();
        userDO = userDOMapper.selectDoByTelephone(telephone);
        if (userDO == null)
            throw new BusinessException(EmBusinssError.USER_LOGIN_FAILD);
        passwordDO = userPasswordDOMapper.selectByUserid(userDO.getId());
        if(userDO.getName() == null || passwordDO.getEncrptPassword() == null)
            throw new BusinessException(EmBusinssError.USERNAMW_OR_PASSwoRD_ERRO);
        if (StringUtils.equals(userDO.getTelephone(),telephone))
            if (StringUtils.equals(passwordDO.getEncrptPassword(),encrpe_password))
                return convertFromDataObject(userDO, passwordDO);
        return null;
    }

    @Transactional
    @Override
    public boolean addUser(UserModel userModel) throws BusinessException {
        if (userModel == null)
            return false;
        UserDO userDo = this.convertFromUserModel(userModel);
        userDo.setThirdPartyId("1312554");
        try {
            userDOMapper.insertSelective(userDo);
        } catch (DuplicateKeyException dup) {
           throw new BusinessException(EmBusinssError.PARAMTER_NOT_VALID,"该手机号已注册");
        }
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
            //获取注册用户的id，给password表赋值
            String userId = (String) userDOMapper.selectIdByTelephone(userModel.getTelephone());
            userPasswordDO.setUserId(userId);
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

