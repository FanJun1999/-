package com.hdax.service;

import com.hdax.entity.SmbmsUser;

public interface SmbmsUserService {

    /**
     * 登录
     * @param username
     * @param userpassword
     * @return
     * @throws Exception
     */
    SmbmsUser login(String username, String userpassword) throws Exception;
}
