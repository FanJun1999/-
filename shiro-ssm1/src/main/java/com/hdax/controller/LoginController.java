package com.hdax.controller;

import com.hdax.constant.Constants;
import com.hdax.entity.SmbmsUser;
import com.hdax.service.SmbmsUserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Log4j
@RequestMapping(path = "/user")
public class LoginController {
    @Autowired
    private SmbmsUserService smbmsUserService;

    public void setSmbmsUserService(SmbmsUserService smbmsUserService) {
        this.smbmsUserService = smbmsUserService;
    }

    /**
     * 登录页面跳转
     * @return
     */
    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> login(@RequestParam("username")String username,
                                      @RequestParam("userpassword")String pwd, HttpSession session) {
        System.out.println("3333333");
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        try {
            SmbmsUser s = smbmsUserService.login(username,pwd);
            session.setAttribute(Constants.LoginInfo.LOGIN_USER,s);
        } catch (Exception e) {
            log.info(e.getMessage());
            map.put("result",false);
            log.error("登录失败!");
        }
        map.put("result",true);
        return map;
    }
}
