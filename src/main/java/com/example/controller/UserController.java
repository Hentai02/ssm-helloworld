package com.example.controller;

import com.example.pojo.BaseResponse;
import com.example.pojo.SsUser;
import com.example.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private UserService userService;

    @ResponseBody
    @GetMapping("/getAnyUserInfo")
    public SsUser getAnyUserInfo(){
        return userService.getAnyUser();
    }

    @RequestMapping(path = "/login.html",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }


    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "/login.do",method = RequestMethod.POST)
    public BaseResponse login(@RequestParam String username,
                                     @RequestParam String password,
                                     HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        password = DigestUtils.md5DigestAsHex((password).getBytes());
        try{
            SsUser user = userService.userVerify(username, password);
            logger.info("username:" + username + ",password:" + password);
            if (user != null){
                session.setAttribute("user",user);
                return BaseResponse.success();
            }else {
                return BaseResponse.fail("账号或密码错误!");
            }
        }catch (Exception e){
            return BaseResponse.error(e);
        }

    }

    /**
     * 首页
     * @return
     */
    @GetMapping(path = "/index.html")
    public String index(HttpSession session, Model model){
        SsUser user = (SsUser) session.getAttribute("user");
        if (user != null){
            model.addAttribute("user",user);
            logger.info(user.toString());
        }
        return "index";
    }

}
