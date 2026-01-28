package com.flm.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flm.dto.Busdetailsdto;
import com.flm.dto.UserRegistrationdto;
import com.flm.model.Busdetails;
import com.flm.model.PlanJourney;
import com.flm.model.UserRegistration;

import jakarta.transaction.Transactional;

public interface PlanRepo extends JpaRepository<PlanJourney, String>{
	@Modifying
	@Transactional
	@Query("UPDATE PlanJourney u SET " +
	       "u.source = :source, " +
	       "u.destination = :destination, " +
	       "u.date = :date, " +
	       "u.day = :day, " +
	       "u.time = :time, " +
	       "u.status = :status, " +
	       "u.user = :user, " +
	       "u.bus = :bus, " +
	       "u.passangers = :passangers " +
	       "WHERE LOWER(u.bookingid) = LOWER(:bookingid)")
	int updateBooking(
	    @Param("source") String source,
	    @Param("destination") String destination,
	    @Param("date") LocalDate date,
	    @Param("day") String day,
	    @Param("time") LocalTime time,
	    @Param("status") String status,
	    @Param("user") UserRegistration user,
	    @Param("bus") Busdetails bus,
	    @Param("passangers") int passangers,
	    @Param("bookingid") String bookingid
	);

	@Modifying
    @Transactional
	@Query("SELECT s FROM PlanJourney s WHERE s.user.userid = :userid ")
	public List<PlanJourney> findBookingsByUser(@Param("userid") String userid);
			@Modifying
		    @Transactional                                    
	@Query("SELECT s FROM PlanJourney s WHERE s.bus.busid = :busid ")
	public List<PlanJourney> findBookingsByBus(@Param("busid") String busid
);
			@Modifying
			@Transactional
			@Query("UPDATE PlanJourney u SET u.status = :status, u.totalamount = :totalamount, u.paymentstatus = :paymentstatus WHERE LOWER(u.bookingid) = LOWER(:bookingid)")
			public int updateBookingStatus(
			    @Param("status") String status,
			    @Param("totalamount") int totalamount,
			    @Param("paymentstatus") String paymentstatus,
@Param("bookingid") String bookingid			   
			);
			@Modifying
			@Transactional
			@Query("UPDATE PlanJourney u SET u.paymentstatus = :paymentstatus WHERE LOWER(u.bookingid) = LOWER(:bookingid)")
			public int updatePaymentStatus(
			  
			    @Param("paymentstatus") String paymentstatus,
@Param("bookingid") String bookingid			   
			);
			@Query("SELECT s FROM PlanJourney s WHERE LOWER(s.bookingid) = LOWER(:bookingid) AND s.paymentstatus = :paymentstatus")
			public PlanJourney findBookingsReceipt(@Param("bookingid") String bookingid, @Param("paymentstatus") String paymentstatus);

			@Modifying
			@Transactional
			@Query("UPDATE PlanJourney u SET u.status = :status WHERE LOWER(u.bookingid) = LOWER(:bookingid)")
			public int cancelBooking(
			  
			    @Param("status") String status,
@Param("bookingid") String bookingid			   
			);
			@Query("SELECT u FROM PlanJourney u LEFT JOIN FETCH u.user LEFT JOIN FETCH u.bus WHERE LOWER(u.bookingid) = LOWER(:bookingid)")
			PlanJourney getBookingById(@Param("bookingid") String bookingid);


			@Modifying
			@Transactional
			@Query("UPDATE PlanJourney u SET  u.totalamount = :totalamount WHERE LOWER(u.bookingid) = LOWER(:bookingid)")
			public int updateAmount(
			    
			    @Param("totalamount") int totalamount,
			   
@Param("bookingid") String bookingid			   
			);	

}
