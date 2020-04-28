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
    public void add(){
        UserService service = new UserService();
        SmbmsUser user = new SmbmsUser();
        user.setUsercode("231321");
        user.setUsername("zhangsan");
        Integer i = new Random().nextInt(1000000);
        user.setSalt(i+"");
        user.setUserpassword(new Md5Hash("123456",user.getSalt()).toString());
        service.user(user);
        System.out.println("增加成功");
    }

    @Test
    public void b() {
        String password = "123456";
        String salt = "111111 ";
        String str = new Md5Hash(password, salt).toString();
        System.out.println(str);
    }

    @Test
    public void a() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-custom.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        String username = "zhangsan";
        String password = "123456";

        //令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //认证主体
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);//CustomRealm
            System.out.println("认证成功!");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            e.printStackTrace();
        }


    }
}
