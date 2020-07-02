package cn.wmyskxz.service;

import cn.wmyskxz.entity.User;

import java.util.List;

public interface UserService {
    /** 查找所有用户 */
    List<User> listAll();

    /** 添加用户 */
    Integer insert(User user);

    /** 根据id删除用户 */
    Integer deleteById(Integer id);

    /** 更新用户 */
    Integer update(User user);

    /** 根据id查找用户 */
    List<User> getById(Integer id,String name,String phone,String sex);
}