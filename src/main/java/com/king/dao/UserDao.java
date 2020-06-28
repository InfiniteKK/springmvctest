package com.king.dao;

import com.king.model.UserModel;

import java.util.List;

public interface UserDao {
    List<UserModel> getAllUsers();
    UserModel getUser(String id);
    boolean addUser();
    boolean updateUser(String id,String name);
    boolean deleteUser(String id);

}
