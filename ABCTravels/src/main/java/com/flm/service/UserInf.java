package com.flm.service;

import java.util.List;

import com.flm.dto.UserRegistrationdto;

public interface UserInf {
public boolean saveUser(UserRegistrationdto ud);
public boolean editUser(String id,UserRegistrationdto ud);
public void deleteUser(String id);
public UserRegistrationdto getUser(String id);
public List<UserRegistrationdto> getAllUsers();
public boolean unLockStatus(String id);
}
