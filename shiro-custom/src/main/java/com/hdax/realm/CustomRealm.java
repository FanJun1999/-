package com.hdax.realm;

import com.hdax.entity.SmbmsUser;
import com.hdax.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SmbmsUser user = (SmbmsUser) principalCollection.getPrimaryPrincipal();
        //授权
        authorizationInfo.addRole("admin");
        authorizationInfo.addRole("role1");
        Set<String> promissions = new HashSet<String>();
        promissions.add("user:update");
        promissions.add("user:create");
        promissions.add("user:select");
        promissions.add("user:delete");
        authorizationInfo.addStringPermissions(promissions);
        return authorizationInfo;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String)token.getPrincipal();//令牌中存储的账号
        UserService userService = new UserService();
        SmbmsUser user = userService.login(principal);

        if(user!=null){
            return new SimpleAuthenticationInfo(user,user.getUserpassword(), ByteSource.Util.bytes(user.getSalt()),getName());
        }

//        String username = "admin";
//        String password = "82f96ee4201cbeda533bba11ee4c566f";
//        String salt = "111111";
//        if(username.equals(principal)){
//            //认证成功
//            return new SimpleAuthenticationInfo(principal,password, ByteSource.Util.bytes(salt),getName());
//        }
        return null;
    }
}
