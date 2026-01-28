package com.flm.serviceinf;

import java.util.List;

import com.flm.dto.AccountDetailsdto;
import com.flm.dto.Userdto;

public interface UserServiceInf {
public void saveuser(Userdto ud);
public boolean getuser(String email,String password);
public List<AccountDetailsdto> listaccount(String email);
public List<String> accountlist(String email);

}
