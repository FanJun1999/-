package com.hdax.mappers;

import com.hdax.entity.SmbmsUser;
import org.apache.ibatis.annotations.Param;

public interface SmbmsUserMapper extends CommonDao<SmbmsUser,Integer> {

    /**
     * 根据用户名称查询用户信息
     * @param username
     * @return
     */
    SmbmsUser findByUsername(@Param("username") String username);
}
