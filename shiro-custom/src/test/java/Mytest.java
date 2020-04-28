import com.hdax.entity.SmbmsUser;
import com.hdax.service.UserService;
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

import java.util.Random;

public class Mytest {

    @Test
    public void test(){
        String password = "1234567";
        String salt = "111111";//盐值
        String str = new Md5Hash(password,salt,2).toString();
        System.out.println(str);
    }

    @Test
    public void saveUser(){
        UserService userService = new UserService();
        SmbmsUser user = new SmbmsUser();
        user.setUsercode("admin");
        user.setUsername("admin");
        int rand = new Random().nextInt(1000000);
        user.setSalt(rand+"");
        user.setUserpassword(new Md5Hash("1234567",user.getSalt(),2).toString());
        userService.user(user);
        System.out.println("新增用户成功");
    }

    @Test
    public void test01(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-custom.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        String username = "admin";
        String password = "200425";

        //令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //认证主体
        Subject subject = SecurityUtils.getSubject();

        try{
            subject.login(token);//CustomRealm
            System.out.println("认证成功!");
            //授权
//            System.out.println("是否是admin1角色:"+subject.hasRole("admin1"));
//            System.out.println("是否能够新建用户:"+subject.isPermitted("user:create"));
//            System.out.println("是否能够修改用户:"+subject.isPermitted("user:update"));
//            System.out.println("是否能够查询用户:"+subject.isPermitted("user:select"));
//            System.out.println("是否能够删除用户:"+subject.isPermitted("user:delete"));
        } catch (UnknownAccountException e){
            e.printStackTrace();
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
        }

    }

    @Test
    public void test02(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-custom.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        String username = "zhangsan";
        String password = "200425";
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);//CustomRealm
            System.out.println("认证成功!");
            System.out.println(subject.hasRole("role1"));
            System.out.println(subject.isPermitted("user:create"));
            System.out.println(subject.isPermitted("user:update"));
            System.out.println(subject.isPermitted("user:delete"));
        } catch (UnknownAccountException e){
            e.printStackTrace();
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
        }
    }
}
