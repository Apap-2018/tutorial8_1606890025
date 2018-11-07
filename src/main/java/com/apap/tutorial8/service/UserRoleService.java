package com.apap.tutorial8.service;

import com.apap.tutorial8.model.ChangePasswordModel;
import com.apap.tutorial8.model.UserRoleModel;

public interface UserRoleService {
    UserRoleModel addUser(UserRoleModel user);
    UserRoleModel getUser(String username);
    void updatePassword(UserRoleModel user, String newPass);
    public String encrypt(String password);
}