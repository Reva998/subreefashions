package com.flm.builder;

import org.springframework.stereotype.Component;

import com.flm.dto.BankStatementdto;
import com.flm.entity.BankStatement;

@Component
public class Bankbuilder {
private BankStatement bs;
private BankStatementdto bd;

public BankStatementdto ben_bdto(BankStatement bs)
{
	bd= new BankStatementdto(bs.getTransid(),bs.getAccount_number(),bs.getUpi_id(),bs.getSender_upi(),bs.getAmount(),bs.getDate(),bs.getBalance());
return bd;
}
public BankStatement bdto_ben(BankStatementdto bd)
{
	bs= new BankStatement(bd.getTransid(),bd.getAccount_number(),bd.getUpi_id(),bd.getSender_upi(),bd.getAmount(),bd.getDate(),bd.getBalance());
return bs;
}
}
