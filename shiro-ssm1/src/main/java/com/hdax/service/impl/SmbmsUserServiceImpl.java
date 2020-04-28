package com.hdax.service.impl;

import com.hdax.constant.Constants;
import com.hdax.entity.SmbmsUser;
import com.hdax.mappers.SmbmsUserMapper;
import com.hdax.service.SmbmsUserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j
@Service
public class SmbmsUserServiceImpl implements SmbmsUserService {

    @Autowired
    private SmbmsUserMapper userMapper;

    public void setUserMapper(SmbmsUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public SmbmsUser login(String username, String userpassword) throws Exception {
        SmbmsUser user = userMapper.findByUsername(username);

        if(user == null){
            log.error(Constants.LoginInfo.ERR_LOGIN_INVALID_USERNAME);
            throw new RuntimeException(Constants.LoginInfo.ERR_LOGIN_INVALID_USERNAME);
        }else{
            //此处对用户填写密码加密后方可判断
            if(!user.getUserpassword().equals(userpassword)){
                log.error(Constants.LoginInfo.ERR_LOGIN_INVALID_PASSWORD);
                throw new RuntimeException(Constants.LoginInfo.ERR_LOGIN_INVALID_PASSWORD);
            }
        }
        return user;
    }
}
