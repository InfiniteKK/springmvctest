package com.king.dao;

import com.king.model.UserModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Resource(name = "myJdbc")
    private JdbcTemplate myJdbc;

    @Override
    public List<UserModel> getAllUsers() {
        String sql = "select * from user";
        return query(sql);
    }

    @Override
    public UserModel getUser(String id) {
        return null;
    }

    @Override
    public boolean addUser() {
        String sql = "insert into user values(3,\"Mark\",18)";
        return add(sql);
    }

    @Override
    public boolean updateUser(String id, String name) {
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }

    private List<UserModel> query(String sql) {
        final List<UserModel> userModels = new ArrayList<>();
        myJdbc.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                UserModel userModel = new UserModel(id, name, age);
                userModels.add(userModel);
            }
        });

        return userModels;
    }
    private boolean add(String sql){
        return  myJdbc.update(sql)>0;
    }
}
