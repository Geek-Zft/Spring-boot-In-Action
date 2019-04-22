package com.zft.thymeleaf.controller;

import com.zft.thymeleaf.dao.UserDao;
import com.zft.thymeleaf.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Description: User Controller.
 * @author  fengtan.zhang
 * @date    2019/4/22 0022 上午 11:51
 * @email   fengtan_zhang@sina.com
 * @version 1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/list")
    public ModelAndView getList(Model model) {

        model.addAttribute("userList",  userDao.getList());
        model.addAttribute("title",  "用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     * 根据ID查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/view/{id}")
    public ModelAndView getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userDao.getUserById(id));
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }


    /**
     * 获取 form 表单页面
     * @param
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 新建用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView create(User user) {
        user = userDao.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users/list");
    }


    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userDao.deleteUser(id);

        model.addAttribute("userList", userDao.getList());
        model.addAttribute("title", "删除用户");
        //重定向到list页面
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 修改用户
     * @return
     */
    @GetMapping(value = "modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userDao.getUserById(id);

        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }

}
