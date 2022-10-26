package com.entity.impl;

import com.entity.User;
import com.entity.inter.AbstractDao;
import com.entity.inter.UserInter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserImpl extends AbstractDao implements UserInter {
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection conn;
        try {
            conn = get();
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT * FROM tinderapp.users");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                users.add(new User(id,email,password));
                }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    public String getPasswordByEmail(String email) {
        List<User> users = new UserImpl().getAllUsers();
        for (User user:users){
            if (email.equals(user.getEmail())){
                return user.getPassword();
            }
        }
        return null;
    }

    public Integer getIDByEmail(String email) {
        List<User> users = new UserImpl().getAllUsers();
        for (User user:users){
            if (email.equals(user.getEmail())){
                return User.getId();
            }
        }
        return null;
    }

}
