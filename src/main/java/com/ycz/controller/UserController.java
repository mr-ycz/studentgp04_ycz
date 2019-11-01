package com.ycz.controller;

import com.ycz.pojo.User;
import com.ycz.pojo.UserVo;
import com.ycz.service.UserService;
import com.ycz.utils.Captcha2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 该类用于处理跟用户相关的各种功能
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录页面
     */
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    /**
     * 登录表单验证
     */
    @PostMapping("/login")
    @ResponseBody
    public String loginLogic(UserVo userVo){

        UsernamePasswordToken token = new UsernamePasswordToken(userVo.getUsername(), userVo.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);


        return "1";
    }

    /**
     * 返回注册页面
     */
    @GetMapping("/regist")
    public String registPage(){
        return "register";
    }

    /**
     * 用户注册
     */
    @PostMapping("/regist")
    public String registLogic(User user, String sta){//用于接收注册界面传来的参数，封装到一个用户对象中
        user.setRegistTime(new Date());
        if ("老师".equals(sta)){
            user.setStatus(1);
        }else {
            user.setStatus(2);
        }

        userService.addUser(user);
        return "login";
    }

    /**
     * 获取验证码
     */
    @RequestMapping("/getCode")
    @ResponseBody
    public String getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Captcha2.generateCaptcha(request, response);
        return "1";
    }

    /**
     * 异步检验验证码
     */
    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(String code, HttpServletRequest request){
        String captcha = (String) request.getSession().getAttribute("captcha");
        if (captcha.equalsIgnoreCase(code)){
            return "0";
        }
        return "1";
    }

}
