package com.flm.serviceimp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.builder.Accountbuilder;
import com.flm.dto.AccountDetailsdto;
import com.flm.entity.AccountDetails;
import com.flm.entity.UserEntity;
import com.flm.repo.AccountRepo;
import com.flm.repo.UserRepo;
import com.flm.serviceinf.AccountServiceInf;
@Service
public class AccountServiceImp implements AccountServiceInf {

    @Autowired
    private Accountbuilder ab;

    @Autowired
    private AccountRepo ar;

    @Autowired
    private UserRepo ur;

    @Override
    public AccountDetailsdto getAccount(String accno, String ifsc, String bankname, String branch) {

        AccountDetails ad = ar.getAcc(accno, ifsc, bankname, branch);

        if (ad == null) {
        	System.out.println("ACC: " + accno);
        	System.out.println("IFSC: " + ifsc);
        	System.out.println("BANK: " + bankname);
        	System.out.println("BRANCH: " + branch);

        	System.out.println("no account fouund");
            return null;
        }

        return ab.aen_adto(ad);
    }

    @Override
    public boolean addAccount(String accno) {

        AccountDetailsdto add = getOne(accno);

        if (add == null) {
        	
            return false;
        }

        UserEntity ue = new UserEntity(
                add.getUsername(),
                add.getEmail(),
                null,
                add.getPhone(),
                add.getAccount_number());
        
        

        UserEntity row = ur.save(ue);
        return row != null;
        
    }

    @Override
    public AccountDetailsdto getOne(String accno) {

        Optional<AccountDetails> op = ar.findById(accno);

        if (op.isEmpty()) {
            return null;
        }

        return ab.aen_adto(op.get());
    }

    @Override
    public void edit(String accno, String email, String phone, String address) {

        int row = ar.updatedet(email, phone, address, accno);

        if (row > 0)
            System.out.println("Update success");
        else
            System.out.println("Update failed");
    }

    @Override
    public int checkbal(String accno) {

        AccountDetailsdto add = getOne(accno);

        if (add == null) {
            return 0;
        }

        return ar.getAccblc(accno);
    }

    @Override
    public boolean upimatch(String accno, String upi) {

        AccountDetails ad = ar.getAccupimatch(accno, upi);
        return ad != null;
    }

    @Override
    public boolean findupi(String upi) {

        AccountDetails ad = ar.getupi(upi);
        return ad != null;
    }

    @Override
    public void updatebal(String acc, int amount) {

        int check = checkbal(acc);
        int res = check - amount;

        int row = ar.updatebal(res, acc);

        if (row > 0)
            System.out.println("balance updated");
        else
            System.out.println("balance update failed");
    }

    @Override
    public void updatesenderblc(String upi, int amount) {

        AccountDetails ad = ar.getupi(upi);
        int res = ad.getBalance() + amount;

        int row = ar.updatesenderbalc(res, upi);

        if (row > 0)
            System.out.println("sender balance updated");
        else
            System.out.println("sender update failed");
    }
}
