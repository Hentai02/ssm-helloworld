package com.example.controller;

import com.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class PagePathController {
    /**
     * 首页
     * @return
     */
    @GetMapping(path = {"/index.html","/index","/"})
    public String index(HttpSession session, Model model){
        return "index";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping(path = "/login.html",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    /**
     * 个人中心
     * @param session
     * @return
     */
    @GetMapping("/user.html")
    public String user(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null){
            return "user";
        }
        return "redirect:/app/";
    }
}
