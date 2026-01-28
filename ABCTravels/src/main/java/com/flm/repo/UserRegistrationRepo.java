package com.flm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flm.model.Login;
import com.flm.model.UserRegistration;

import jakarta.transaction.Transactional;

public interface UserRegistrationRepo extends JpaRepository<UserRegistration, String>{
	@Query("SELECT u FROM UserRegistration u WHERE u.email = :email")
	public UserRegistration validate(@Param("email") String email);

@Modifying
@Transactional
@Query("UPDATE UserRegistration u SET u.firstname = :firstname, u.secondname = :secondname, u.phone = :phone, u.gender = :gender, u.email = :email, u.password = :password, u.failedcount = :failedcount, u.status = :status WHERE u.userid = :userid")
public int updateUser(
    @Param("firstname") String firstname,
    @Param("secondname") String secondname,
    @Param("phone") String phone,
    @Param("gender") String gender,
    @Param("email") String email,
    @Param("password") String password,
    @Param("failedcount") int failedcount,
    @Param("status") String status,
    @Param("userid") String userid
);
@Modifying
@Transactional
@Query("UPDATE UserRegistration u SET  u.failedcount = :failedcount, u.status = :status WHERE u.userid = :userid")
public void updatefailedcount(
   
    @Param("failedcount") int failedcount,
    @Param("status") String status,
    @Param("userid") String userid
);
@Modifying
@Transactional
@Query("UPDATE UserRegistration u SET  u.status = :status WHERE u.userid = :userid")
public int updatestatus(
 
    @Param("status") String status,
    @Param("userid") String userid
);
}
