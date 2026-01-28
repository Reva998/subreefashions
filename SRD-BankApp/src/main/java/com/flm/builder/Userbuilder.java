package com.flm.builder;

import org.springframework.stereotype.Component;

import com.flm.dto.Userdto;
import com.flm.entity.UserEntity;

@Component
public class Userbuilder {
private UserEntity ue;
private Userdto ud;

public Userdto uen_udto(UserEntity ue)
{
	ud= new Userdto(ue.getUsername(),ue.getEmail(),ue.getPassword(),ue.getPhone(),ue.getAccount_number());
	return ud;
}
public UserEntity udto_uen(Userdto ud)
{
	ue= new UserEntity(ud.getUsername(),ud.getEmail(),ud.getPassword(),ud.getPhone(),ud.getAccount_number());
	return ue;
}
}
