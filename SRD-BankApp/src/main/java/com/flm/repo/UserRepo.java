package com.flm.repo;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flm.entity.UserEntity;



public interface UserRepo extends JpaRepository<UserEntity, String>  {

	@Query("SELECT s FROM UserEntity s WHERE s.email = :email AND s.password = :password")
	public UserEntity getUser(@Param("email") String email,
	                                          @Param("password") String password);
	@Query("SELECT s.account_number FROM UserEntity s WHERE s.email = :email ")
	public List<String> getUseracc(@Param("email") String email
	                                         );
	
}
