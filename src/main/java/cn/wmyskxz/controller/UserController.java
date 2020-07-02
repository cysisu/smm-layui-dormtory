package cn.wmyskxz.controller;

import cn.wmyskxz.entity.User;
import cn.wmyskxz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * User 的控制类
 *
 * @author: @我没有三颗心脏
 * @create: 2018-04-23-上午 9:58
 */
@Controller
@RequestMapping("")
public class UserController {

    @Resource
    private UserService userService;

    /** 跳转至用户页面 */
    @RequestMapping("")
    public String toUser() {
        return "login";
    }


}