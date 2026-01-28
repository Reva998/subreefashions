package com.flm.repo;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flm.entity.Items;

import jakarta.transaction.Transactional;

public interface ItemsRepo extends JpaRepository<Items,Integer>{
	@Modifying
	@Transactional
	@Query("UPDATE Items u SET u.proname = :proname, u.rate = :rate, u.gst = :gst, u.total_quantity = :total_quantity, u.supplier = :supplier, u.supplier_add = :supplier_add, u.quantity_per = :quantity_per WHERE u.code = :code")
	public int updatePro(
	    @Param("proname") String proname,
	    @Param("rate") int rate,
	    @Param("gst") float gst,
	    
	    @Param("total_quantity") int total_quantity,
	    @Param("supplier") String supplier,
	    @Param("supplier_add") String supplier_add,
	  @Param("quantity_per") int quantity_per,
	    @Param("code") int code
	);

@Modifying
@Transactional
@Query("UPDATE Items u SET  u.total_quantity = :total_quantity WHERE u.code = :code")
public int updatequn(

    
    @Param("total_quantity") int total_quantity,
   
    @Param("code") int code
);
}