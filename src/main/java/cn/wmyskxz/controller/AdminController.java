package cn.wmyskxz.controller;

import cn.wmyskxz.entity.Menu;
import cn.wmyskxz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String username, String password, HttpServletRequest request, HttpSession session)
            throws ParseException {
        int result = adminService.loginCheck(username, password);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            session.setAttribute("username", username);
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping("index")
    public String toUser() {
        return "index";
    }

    @RequestMapping("/main")
    public String getMain() {
        return "/jsp/main";
    }

    @RequestMapping("/customer")
    public String getCustomer() {
        return "/jsp/customer";
    }

    @RequestMapping("/room")
    public String getRoom() {
        return "/jsp/room";
    }

    @RequestMapping("/getMenus")
    @ResponseBody
    public List<Menu> getMenus(HttpSession session){
        List<Menu> menus = adminService.getMenus();
        System.out.println("大小："+menus.size());
        return menus;
    }


}
