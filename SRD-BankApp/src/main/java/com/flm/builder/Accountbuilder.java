package com.flm.builder;

import org.springframework.stereotype.Component;

import com.flm.dto.AccountDetailsdto;
import com.flm.entity.AccountDetails;

@Component
public class Accountbuilder {
 private AccountDetails ad;
 private AccountDetailsdto addt;
 public AccountDetailsdto aen_adto(AccountDetails ad)
 {
	 addt= new AccountDetailsdto(ad.getAccount_number(),ad.getUsername(),ad.getIfsc(),ad.getUpi_id(),ad.getBankname(),ad.getBranch(),ad.getPhone(),ad.getEmail(),ad.getAddress(),ad.getBalance());
 
 return addt;
 }
 public AccountDetails adto_aen(AccountDetailsdto addt)
 {
	 ad= new AccountDetails(addt.getAccount_number(),addt.getUsername(),addt.getIfsc(),addt.getUpi_id(),addt.getBankname(),addt.getBranch(),addt.getPhone(),addt.getEmail(),addt.getAddress(),addt.getBalance());
 
 return ad;
 }
}
