package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.BaseResponse;
import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private UserService userService;

    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(path = "/login.do",method = RequestMethod.POST)
    public BaseResponse login(@RequestParam String username,
                                     @RequestParam String password,
                                     HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        password = DigestUtils.md5DigestAsHex((password).getBytes());
        try{
            User user = userService.userVerify(username, password);
            if (user != null){
                if (user.getIsDel() < 0)
                    return BaseResponse.fail("账号封禁中！");
                session.setAttribute("user",user);
                return BaseResponse.success();
            }else
                return BaseResponse.fail("账号或密码错误!");
        }catch (Exception e){
            return BaseResponse.error(e);
        }

    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @PostMapping("/user/logout.do")
    public BaseResponse logout(HttpSession session){
        session.removeAttribute("user");
        return BaseResponse.success("退出成功！");
    }

    /**
     * 获取当前用户信息
     * @param session
     * @return
     */
    @PostMapping("/user/getUserInfo.do")
    public BaseResponse userInfo(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null){
            return BaseResponse.success(user);
        }
        return BaseResponse.fail("请先登录！");

    }

    /**
     * 获取所有用户信息
     * @return
     */
    @PostMapping("/user/getAllUser.do")
    public BaseResponse getAllUser(){
        List<User> users = userService.getUser(0);
        return BaseResponse.success(users);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PostMapping("/user/updateUserInfo.do")
    public BaseResponse updateUserInfo(HttpSession session,@RequestBody User user){
        User sessionUser = (User) session.getAttribute("user");

        User srcUser = userService.getUser(user.getId()).get(0);
        if (user.getPassword().equals(srcUser.getPassword())){
            user.setPassword(srcUser.getPassword());
        }else{
            String password = DigestUtils.md5DigestAsHex((user.getPassword()).getBytes());
            user.setPassword(password);
        }

//        if(user.getPassword().equals(current_user.getPassword())){
//            user.setPassword(current_user.getPassword());
//        }else{
//            String password = DigestUtils.md5DigestAsHex((user.getPassword()).getBytes());
//            user.setPassword(password);
//        }

        user.setUpdateTime(new Date());
        user.setCreateBy(sessionUser.getUsername());
        int row = userService.updateUserInfo(user);
        if (row == 1){
            if (sessionUser.getId().equals(user.getId())){
                session.removeAttribute("user");
                session.setAttribute("user",user);
            }
            return BaseResponse.success();
        }else{
            return BaseResponse.fail("保存失败！");
        }
    }

    /**
     * 修改用户状态信息
     * @param id
     * @return
     */
    @PostMapping("/user/changeUserStatus.do")
    public BaseResponse deleteUser(@RequestParam int status,@RequestParam int id){
        if (id == 1){
            return BaseResponse.fail("不能封禁管理员账号！");
        }
        userService.changeUserStatus(status,id);
        return BaseResponse.success();
    }
}
