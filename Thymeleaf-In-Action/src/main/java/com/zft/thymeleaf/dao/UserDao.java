package com.zft.thymeleaf.dao;

import com.zft.thymeleaf.entity.User;

import java.util.List;

/**
 * Description: User Dao.
 * @author  fengtan.zhang
 * @date    2019/4/22 0022 上午 11:31
 * @email   fengtan_zhang@sina.com
 * @version 1.0
 */
public interface UserDao {


    User saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> getList();
}
