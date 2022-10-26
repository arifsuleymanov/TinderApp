package com.entity.inter;

import com.entity.User;

import java.util.List;

public interface UserInter {

    List<User> getAllUsers();
    String getPasswordByEmail(String email);

}
