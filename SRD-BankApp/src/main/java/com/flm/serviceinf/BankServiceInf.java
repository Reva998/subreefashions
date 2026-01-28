package com.flm.serviceinf;

import java.util.List;

import com.flm.dto.BankStatementdto;

public interface BankServiceInf {
public boolean addtrans(BankStatementdto bd);
public List<BankStatementdto> getStatement(String accno);
}
