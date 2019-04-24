package com.zft.securityinaction.entity;

/**
 * Description: User.
 * @author  fengtan.zhang
 * @date    2019/4/22 0022 上午 11:27
 * @email   fengtan_zhang@sina.com
 * @version 1.0
 */
public class User {

    /** 主键*/
    private Long id;

    private String name;

    private String email;

    public User() {}

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
