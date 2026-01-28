package com.flm.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.builder.Userbuilder;
import com.flm.dto.AccountDetailsdto;
import com.flm.dto.Userdto;
import com.flm.entity.UserEntity;
import com.flm.repo.UserRepo;
import com.flm.serviceinf.AccountServiceInf;
import com.flm.serviceinf.UserServiceInf;
@Service
public class UserServiceImp implements UserServiceInf {
@Autowired
private Userbuilder ub;
@Autowired
private UserRepo ur;
private UserEntity ue;
private Userdto ud;
private AccountDetailsdto ad;
@Autowired
private AccountServiceInf ai;
	@Override
	public void saveuser(Userdto ud) {
		
		ue=ub.udto_uen(ud);
		ur.save(ue);
	}

	@Override
	public boolean getuser(String email, String password) {
		ue=ur.getUser(email, password);
		if (ue!=null)
		{
			return true;
		}else
		{
			return false;
		}
	}

	@Override
	public List<AccountDetailsdto> listaccount(String email) {
		List<String> acc= new ArrayList<String>();
		List<AccountDetailsdto> add= new ArrayList<>();
		acc=ur.getUseracc(email); 
		for(String accno :acc)
		{// TODO Auto-generated method stub
			AccountDetailsdto adto=ai.getOne(accno);
			add.add(adto);
		}
		return add;
	}

	@Override
	public List<String> accountlist(String email) {
		List<String> accounts= ur.getUseracc(email);
		List<String> acc= new ArrayList<>();
		for(String st: accounts)
		{// TODO Auto-generated method stub
	 ad=	ai.getOne(st);
	// String res = st + " - " + ad.getBankname();
	 String res=ad.getAccount_number();
	 acc.add(res);
		}
		return acc;
	}

}
