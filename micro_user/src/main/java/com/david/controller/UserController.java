package com.david.controller;

import com.david.service.UserService;
import com.david.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用戶Controller
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Integer id) {
        System.out.println("2222222");
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody User user) {
        userService.add(user);
        return "新增成功";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@RequestBody User user, @PathVariable(name = "id") Integer id) {
        user.setId(id);
        userService.update(user);
        return "修改成功";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Integer id) {
        userService.delete(id);
        return "刪除成功";
    }

}
