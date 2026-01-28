package com.flm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flm.entity.BankStatement;

public interface BankRepo extends JpaRepository<BankStatement,String> {
	@Query("SELECT s FROM BankStatement s WHERE s.account_number = :accno ")
	public List<BankStatement> getstat(@Param("accno") String accno
	                                         );
}
