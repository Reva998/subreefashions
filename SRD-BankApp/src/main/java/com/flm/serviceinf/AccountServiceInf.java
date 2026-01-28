package com.flm.serviceinf;

import com.flm.dto.AccountDetailsdto;

public interface AccountServiceInf {

	public AccountDetailsdto getAccount(String accno,String ifsc,String bankname,String branch);
	public boolean addAccount(String accno);
	public AccountDetailsdto getOne(String accno);
	public void edit(String accno,String email,String phone,String address);
	public int checkbal(String accno);
	public boolean upimatch(String accno,String upi);
	public boolean findupi(String upi);
	public void updatebal(String acc,int amount);
	public void updatesenderblc(String upi,int amount);
	

}
