package com.king.controller;

import com.king.dao.UserDao;
import com.king.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserDao userDao;
    @Autowired
    UserController(UserDao userDao){
        this.userDao=userDao;
    }
    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List<UserModel> getAllUsers(){
        List<UserModel> userModels = userDao.getAllUsers();
        return userModels;
    }
    @RequestMapping("/addUser")
    @ResponseBody
    public boolean add(){
        return userDao.addUser();
    }
}
