package com.flm.service;

import com.flm.dto.Logindto;
import com.flm.model.Login;

public interface LoginInf {
public boolean validateUser(Logindto log);
public void logout(String email);
}
