package cn.wmyskxz.dao;

import cn.wmyskxz.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /** 查找所有用户 */
    List<User> listAll();

    /** 添加用户 */
    Integer insert(User user);

    /** 根据id删除用户 */
    Integer deleteById(Integer id);

    /** 更新用户 */
    Integer update(User user);

    /** 根据id查找用户 */
    List<User> getById(@Param("id")Integer id, @Param("name")String name, @Param("phone")String phone, @Param("sex")String sex);

    int loginCheck(@Param("name")String name ,@Param("password")String password);
}