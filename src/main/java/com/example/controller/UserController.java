package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.pojo.BaseResponse;
import com.example.pojo.UploadInfo;
import com.example.pojo.User;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@RestController
public class UserController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private UserMapper userMapper;


    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/reg.do")
    public BaseResponse reg(@RequestParam String username,
                            @RequestParam String password){

        User data = userMapper.userVerify(username, null);
        if (data != null)return BaseResponse.fail("用户名已被使用！");
        User user = new User();
        user.setNickname(username);
        user.setUsername(username);
        password = DigestUtils.md5DigestAsHex((password).getBytes());
        user.setPassword(password);
        user.setAvatar("/app/data/user/avatar.png");
        user.setGender("男");
        user.setAddress("");
        user.setPhone("");
        user.setIsDel(0);
        user.setCreateBy(username);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setUpdateBy(username);
        userMapper.insert(user);
        logger.info("用户" + user.getUsername() + "注册");
        return BaseResponse.success("注册成功！",201);
    }

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
        password = DigestUtils.md5DigestAsHex((password).getBytes());
        try{
            User user = userMapper.userVerify(username, password);
            if (user != null){
                if (user.getIsDel() < 0)
                    return BaseResponse.fail("账号封禁中！");
                session.setAttribute("user",user);
                logger.info("用户" + user.getUsername() + "登录");
                return BaseResponse.success("登录成功！",200);
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
        List<User> users = userMapper.getUser(0);
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
        User srcUser = userMapper.getUser(user.getId()).get(0);
        UploadInfo uploadInfo = (UploadInfo) session.getAttribute("uploadInfo");
        if (uploadInfo != null){
            File dir = uploadInfo.tmpFile.getParentFile().getParentFile();
            try {
                FileUtils.delete(uploadInfo.tmpFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            File srcFile = new File(dir,"/data/user/" + uploadInfo.tmpFileName);
            File destFile = new File(dir,"/data/user/" + sessionUser.getUsername() + "." + uploadInfo.suffix);
            try {
                if (destFile.exists()){
                    FileUtils.delete(destFile);
                }
                FileUtils.moveFile(srcFile,destFile);
//                if (destFile.exists()){
//                    FileUtils.delete(srcFile);
//                }
                user.setAvatar("/app/data/user/"+ destFile.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            logger.error(dir);
        }
        if (user.getPassword().equals(srcUser.getPassword())){
            user.setPassword(srcUser.getPassword());
        }else{
            String password = DigestUtils.md5DigestAsHex((user.getPassword()).getBytes());
            user.setPassword(password);
        }
        user.setUpdateTime(new Date());
        user.setCreateBy(sessionUser.getUsername());
        int row = userMapper.updateUserInfo(user);
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
     * 更新用户地址
     * @param user
     * @return
     */
    @PostMapping("/user/updateUserAddress.do")
    public BaseResponse updateUserAddress(HttpSession session,@RequestBody User user){
        User sessionUser = (User) session.getAttribute("user");
        sessionUser.setPhone(user.getPhone());
        sessionUser.setAddress(user.getAddress());
        sessionUser.setUpdateTime(new Date());
        sessionUser.setCreateBy(sessionUser.getUsername());
        userMapper.updateUserAddress(sessionUser);
        return BaseResponse.success("修改成功！");
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
        userMapper.changeUserStatus(status,id);
        return BaseResponse.success();
    }
}
