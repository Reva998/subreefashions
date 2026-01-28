package com.flm.repo;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flm.entity.AccountDetails;
import com.flm.entity.UserEntity;

import jakarta.transaction.Transactional;

public interface AccountRepo extends JpaRepository<AccountDetails,String>
{

	@Query("SELECT s FROM AccountDetails s WHERE s.account_number = :accno AND s.ifsc = :ifsc AND s.bankname= :bankname AND s.branch= :branch")
	public AccountDetails getAcc(@Param("accno") String accno,
	                                          @Param("ifsc") String ifsc, @Param("bankname") String bankname, @Param("branch") String branch);

	@Modifying
	@Transactional
	@Query("UPDATE AccountDetails u SET u.email = :email, u.phone = :phone, u.address = :address WHERE u.account_number = :accno")
	public int updatedet(
	    @Param("email") String email,
	    @Param("phone") String phone,
	   
	    @Param("address") String address,
	    
	    @Param("accno") String accno
	);


	@Query("SELECT s.balance FROM AccountDetails s WHERE s.account_number = :accno")
	public int getAccblc(@Param("accno") String accno);
	                                         
	@Query("SELECT s FROM AccountDetails s WHERE s.account_number = :accno AND s.upi_id = :upi")
			
	public AccountDetails getAccupimatch(@Param("accno") String accno, @Param("upi") String upi);
	@Query("SELECT s FROM AccountDetails s WHERE s.upi_id = :upi")
	public AccountDetails getupi(@Param("upi") String upi);
	@Modifying
	@Transactional
	@Query("UPDATE AccountDetails u SET u.balance = :balance WHERE u.account_number = :accno")
	public int updatebal(
	    @Param("balance") int balance,
	    
	    
	    @Param("accno") String accno
	);
	@Modifying
	@Transactional
	@Query("UPDATE AccountDetails u SET u.balance = :balance WHERE u.upi_id = :upi")
	public int updatesenderbalc(
	    @Param("balance") int balance,
	    
	    
	    @Param("upi") String upi
	);
}
