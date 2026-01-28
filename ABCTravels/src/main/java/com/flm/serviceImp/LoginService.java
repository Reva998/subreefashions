package com.flm.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.dto.Logindto;
import com.flm.model.Login;
import com.flm.model.UserRegistration;
import com.flm.repo.LoginRepo;
import com.flm.repo.UserRegistrationRepo;
import com.flm.service.LoginInf;

@Service
public class LoginService implements LoginInf
{
	
	@Autowired
	private UserRegistrationRepo ur;
	
	private UserRegistration urg;
	
	private Login login;
	@Autowired
	private LoginRepo lr;
@Override
public boolean validateUser(Logindto log) {
    UserRegistration user = ur.validate(log.getEmail());

    if (user == null) {
        System.out.println("No email found");
        return false;
    }

    String em = user.getEmail();
    String ps = user.getPassword();
    String st = user.getStatus();
    int fc = user.getFailedcount();
    String uid = user.getUserid();

    if (em.equals(log.getEmail())) {
        if (fc >= 5 || "locked".equalsIgnoreCase(st)) {
            System.out.println("Account is locked. Please unlock.");
            return false;
        }

        if (ps.equals(log.getPassword())) {
            // Optionally reset failed count here
            return true;
        } else {
            fc++;
            if (fc >= 5) {
                st = "locked";
            }
            ur.updatefailedcount(fc, st, uid);
            return false;
        }
    } else {
        System.out.println("Email mismatch.");
        return false;
    }
}
@Override
public void logout(String email) {
boolean flag= lr.existsByEmail(email);
if(flag==true)
{
	lr.deleteByEmail(email);
}else
{
	System.out.println("no such login details found");
}
}
}
