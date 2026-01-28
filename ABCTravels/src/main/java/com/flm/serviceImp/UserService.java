package com.flm.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.builder.UserBuilder;
import com.flm.dto.UserRegistrationdto;
import com.flm.model.UserRegistration;
import com.flm.repo.UserRegistrationRepo;
import com.flm.service.UserInf;

import jakarta.transaction.Transactional;
@Service
public class UserService implements UserInf {
@Autowired
private UserBuilder ub;
@Autowired
private UserRegistrationRepo ur;

private UserRegistration urr;

private UserRegistrationdto udto;

	@Override
	public boolean saveUser(UserRegistrationdto ud) {
	urr=ub.user_dto_e(ud);	
	urr=ur.save(urr);
		if(urr!=null)
			{
			return true;
			}
		else
			return false;
	}
@Transactional
	@Override
	public boolean editUser(String id, UserRegistrationdto ud) {
		udto=getUser(id);
		if(udto!=null)
		{
			int row = ur.updateUser(
		            ud.getFirstname(),
		            ud.getSecondname(),
		            ud.getPhone(),
		            ud.getGender(),
		            ud.getEmail(),
		            ud.getPassword(),
		            ud.getFailedcouts(),
		            ud.getStatus(),
		            id
		        );
		if(row>0)
		{
			return true;
		}else
		{
			System.out.println("eroor in updation");
			return false;
		}
		}
		else
		{
			System.out.println("no user to update");
			return false;
		}
	}
@Transactional
	@Override
	public void deleteUser(String id) {
	udto=getUser(id);
	if(udto!=null)
	{
	ur.deleteById(id);
	}
	else
		System.out.println("no user found to delete");
	}
	@Override
	public UserRegistrationdto getUser(String id) {
	Optional<UserRegistration> urr=ur.findById(id);
	if(urr.isPresent())
	{
		udto=ub.user_e_dto_id(urr.get());
		
	}else
	{
		System.out.println("no details found");
	
		
	}
	return udto;
	}

	@Override
	public List<UserRegistrationdto> getAllUsers() {
		List<UserRegistration> ug= ur.findAll();
		List<UserRegistrationdto> uddto=new ArrayList<>();
		for(UserRegistration ugr :ug)
		{// TODO Auto-generated method stub
		uddto.add(ub.user_e_dto_id(ugr));	
		}
		return uddto;
	}
	@Transactional
	@Override
	public boolean unLockStatus(String id) {
int row=ur.updatestatus("active", id);
if(row>0)
{
	return true;
}else
{
		return false;
}
	}

}
