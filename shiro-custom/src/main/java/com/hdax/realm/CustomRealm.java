package com.hdax.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        if (!"zhangsan".equals(principal)) {
            return null;
        }
        String username = "zhangsan";
        String password = "62d41ea50e943b4c346e2a2773c43d8a";
        String salt = "111111";
        if (username.equals(principal)) {
            //认证成功
            return new SimpleAuthenticationInfo(principal, password, ByteSource.Util.bytes(salt), getName());
        }
        return null;
    }
}
