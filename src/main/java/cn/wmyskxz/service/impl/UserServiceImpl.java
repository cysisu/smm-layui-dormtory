package cn.wmyskxz.service.impl;

import cn.wmyskxz.dao.UserDao;
import cn.wmyskxz.entity.User;
import cn.wmyskxz.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserService 对应的实现类
 *
 * @author: @我没有三颗心脏
 * @create: 2018-04-23-上午 9:31
 */

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public List<User> listAll() {
        return userDao.listAll();
    }

    public Integer insert(User user) {
        return userDao.insert(user);
    }

    public Integer deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    public Integer update(User user) {
        return userDao.update(user);
    }

    public List<User> getById(Integer id,String name,String phone,String sex) {
        return userDao.getById( id, name, phone, sex);
    }
}