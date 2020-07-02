package cn.wmyskxz.service;

import cn.wmyskxz.entity.Menu;

import java.util.List;

public interface AdminService {
    /************************Menu相关************************/
    List<Menu> getMenus();

    int loginCheck(String name,String password);
}
