package com.flm.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.builder.Bankbuilder;
import com.flm.dto.AccountDetailsdto;
import com.flm.dto.BankStatementdto;
import com.flm.entity.BankStatement;
import com.flm.repo.BankRepo;
import com.flm.serviceinf.AccountServiceInf;
import com.flm.serviceinf.BankServiceInf;
@Service
public class BankServiceImp implements BankServiceInf {
@Autowired
private Bankbuilder bbd;
@Autowired
private BankRepo br;

private AccountDetailsdto ad;
@Autowired
private AccountServiceInf as;
	@Override
	public boolean addtrans(BankStatementdto bd) {
		ad= as.getOne(bd.getAccount_number());
		boolean res =false;
		if(ad!=null)
		{// TODO Auto-generated method stub
			boolean match=as.upimatch(bd.getAccount_number(), bd.getUpi_id());
			if(match)
			{
				boolean match1=as.findupi(bd.getSender_upi());
				if(match1)
				{
				BankStatement bst=br.save(bbd.bdto_ben(bd));
				if(bst!=null)
				{
					res= true;
					as.updatebal(bd.getAccount_number(), bd.getAmount());
					as.updatesenderblc(bd.getSender_upi(), bd.getAmount());
				}else
				{
					res= false;
				}
				}else
				{
					res= false;
				}
			}
		}
		else
		{
		res= false;
	}
		return res;
	}

	@Override
	public List<BankStatementdto> getStatement(String accno) {
	List<BankStatement> bst= new ArrayList<>();	
	List<BankStatementdto> bsdto= new ArrayList<>();
	bst= br.getstat(accno);
	for(BankStatement bk:bst)
	{// TODO Auto-generated method stub
		bsdto.add(bbd.ben_bdto(bk));
	}
		return bsdto;
	}

}
