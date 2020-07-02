package cn.wmyskxz.service.impl;

import cn.wmyskxz.dao.OrderDao;
import cn.wmyskxz.dao.UserDao;
import cn.wmyskxz.entity.Menu;
import cn.wmyskxz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    /************************************Menu相关************************************/
    public List<Menu> getMenus() {
        List<Menu> menus=new ArrayList<Menu>();
        Menu menu=new Menu();
        menu.setMenuId(Long.parseLong("1"));
        menu.setName("后台首页");
        menu.setIcon("&#xe68e;");
        menu.setSpread("false");
        menu.setParentId(Long.parseLong("0"));
        menu.setSorting(Long.parseLong("99999"));
        menus.add(menu);

        menu=new Menu();
        menu.setMenuId(Long.parseLong("2"));
        menu.setName("房间信息");
//        menu.setIcon("&#xe66f;");
        menu.setSpread("false");
        menu.setHref("/admin/room");
        menu.setParentId(Long.parseLong("0"));
        menu.setSorting(Long.parseLong("9998"));
        menus.add(menu);

        menu=new Menu();
        menu.setMenuId(Long.parseLong("3"));
        menu.setName("添加客户");
        menu.setSpread("false");
        menu.setHref("/admin/customer");
        menu.setParentId(Long.parseLong("0"));
        menu.setSorting(Long.parseLong("9997"));
        menus.add(menu);

        System.out.println(menu);
        return menus;
    }

    /************************************登录相关************************************/
    @Autowired
    private UserDao userDao;
    public int loginCheck(String name, String password){
        return userDao.loginCheck(name,password);
    }
}
