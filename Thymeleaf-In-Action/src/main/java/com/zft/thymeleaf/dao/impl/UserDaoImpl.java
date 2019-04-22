package com.zft.thymeleaf.dao.impl;

import com.zft.thymeleaf.dao.UserDao;
import com.zft.thymeleaf.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserDaoImpl implements UserDao {


    /**
     * 模拟id
     */
    private static AtomicLong counter = new AtomicLong();

    /**
     * 用来存储数据，不用到关系型数据库
     */
    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<Long, User>();

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if(id == null) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id,user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> getList() {
        return new ArrayList<User>(this.userMap.values());
    }
}
