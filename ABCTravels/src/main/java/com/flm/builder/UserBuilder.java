package com.flm.builder;




import org.springframework.stereotype.Component;

import com.flm.dto.UserRegistrationdto;
import com.flm.model.UserRegistration;
@Component
public class UserBuilder {

private UserRegistration ur;

private UserRegistrationdto udto;
public UserRegistrationdto user_e_dto(UserRegistration ur)
{
	udto=new UserRegistrationdto(ur.getFirstname(),ur.getSecondname(),ur.getPhone(),ur.getGender(),ur.getEmail(),ur.getPassword(),ur.getFailedcount(),ur.getStatus());
	return udto;
}
public UserRegistrationdto user_e_dto_id(UserRegistration ur)
{
	udto=new UserRegistrationdto(ur.getUserid(),ur.getFirstname(),ur.getSecondname(),ur.getPhone(),ur.getGender(),ur.getEmail(),ur.getPassword(),ur.getFailedcount(),ur.getStatus());
	return udto;
}
public UserRegistration user_dto_e(UserRegistrationdto udto)
{
	ur=new UserRegistration(udto.getFirstname(),udto.getSecondname(),udto.getPhone(),udto.getGender(),udto.getEmail(),udto.getPassword(),udto.getFailedcouts(),udto.getStatus());
	return ur;
}
public UserRegistration user_dto_e_id(UserRegistrationdto udto)
{
	ur=new UserRegistration(udto.getUserid(),udto.getFirstname(),udto.getSecondname(),udto.getPhone(),udto.getGender(),udto.getEmail(),udto.getPassword(),udto.getFailedcouts(),udto.getStatus());
	return ur;
}
}
