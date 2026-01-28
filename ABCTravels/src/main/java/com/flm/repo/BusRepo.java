package com.flm.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flm.model.Busdetails;

import jakarta.transaction.Transactional;

public interface BusRepo extends JpaRepository<Busdetails, String> {
	@Modifying
	@Transactional
	@Query("UPDATE Busdetails u SET u.source = :source, u.destination = :destination, u.date = :date, u.day = :day, u.arrivaltime = :arrivaltime, u.depaturetime = :depaturetime, u.vaccancies = :vaccancies,u.amount= :amount WHERE u.busid = :busid")
	public int updateBus(
	    @Param("source") String source,
	    @Param("destination") String destination,
	    @Param("date") LocalDate date,
	    @Param("day") String day,
	    @Param("arrivaltime") LocalTime arrivaltime,
	    @Param("depaturetime") LocalTime depaturetime,
	    @Param("vaccancies") int  vaccancies,
	  @Param("amount") int amount,
	    @Param("busid") String busid
	);

    @Modifying
    @Transactional
    @Query("UPDATE Busdetails u SET u.vaccancies = :vaccancies WHERE u.busid = :busid")
    public int updatevacc(
        @Param("vaccancies") int vaccancies,
        @Param("busid") String busid
    );


	@Query("SELECT s FROM Busdetails s WHERE s.date = :date AND s.day = :day AND s.arrivaltime = :time")
	public List<Busdetails> findByDateAndDayAndArrivalTime(@Param("date") LocalDate date,
	                                          @Param("day") String day,
	                                                                                                                  @Param("time") LocalTime time);
	
	@Query("SELECT s FROM Busdetails s WHERE s.source = :source AND s.destination = :destination AND s.busid = :busid")
public List<Busdetails> findBySourceDestinationBus(@Param("source") String source,
	                                          @Param("destination") String destination,
	                                          @Param("busid") String busid);
}
