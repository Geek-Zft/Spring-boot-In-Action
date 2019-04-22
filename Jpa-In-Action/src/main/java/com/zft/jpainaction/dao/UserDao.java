package com.zft.jpainaction.dao;

import com.zft.jpainaction.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Description: User Dao.
 * @author  fengtan.zhang
 * @date    2019/4/22 0022 上午 11:31
 * @email   fengtan_zhang@sina.com
 * @version 1.0
 */
public interface UserDao extends CrudRepository<User, Long>{


}
