package com.hdax.test;


import lombok.Data;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class Mytest {

    @Test
    public void a(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","123");

        try {
            subject.login(token);
            System.out.println("认证成功");
        } catch (UnknownAccountException e) {
            System.out.println("账号错误");
            e.printStackTrace();
        } catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
            e.printStackTrace();
        }

        System.out.println(subject.isAuthenticated());
    }
}
