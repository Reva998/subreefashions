package com.flm.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.builder.BusBuilder;
import com.flm.dto.Busdetailsdto;
import com.flm.dto.UserRegistrationdto;
import com.flm.model.Busdetails;
import com.flm.model.UserRegistration;
import com.flm.repo.BusRepo;
import com.flm.service.BusInf;
@Service
public class BusService implements BusInf {
@Autowired
private BusRepo br;
@Autowired
private BusBuilder bb;

private Busdetails bd;

private Busdetailsdto bdto;
	@Override
	public boolean saveBus(Busdetailsdto bdto) {
		
			bd=bb.bus_dto_e(bdto);	
			bd=br.save(bd);
				if( bd!=null)
					{
					return true;
					}
				else
					return false;
			}

	

	@Override
	public boolean editBus(String id, Busdetailsdto bd) {
		bdto=getBus(id);
		if(bdto!=null)
		{
			
			int row = br.updateBus(
		           bd.getSource(),
		            bd.getDestination(),
		            bd.getDate(),
		            bd.getDay(),
		            bd.getArrivaltime(),
		            bd.getDepaturetime(),
		           
		            bd.getVaccancies(),
		            bd.getAmount(),
		            id
		        );
		if(row>0)
		{
			return true;
		}else
		{
			System.out.println("eroor in updation");
			return false;
		}
		}
		else
		{
			System.out.println("no bus to update");
			return false;
		}
	}
	

	@Override
	public void deleteBus(String id) {
		bdto=getBus(id);
		if(bdto!=null)
		{
		br.deleteById(id);
		}
		else
			System.out.println("no bus found to delete");
		}
	

	@Override
	public Busdetailsdto getBus(String id) {
		Optional<Busdetails> brr=br.findById(id);
		if(brr.isPresent())
		{
			bdto=bb.bus_e_dto(brr.get());
			
		}else
		{
			System.out.println("no details found");
		
			
		}
		return bdto;
		}
	

	@Override
	public List<Busdetailsdto> getAllBus() {
		List<Busdetails> ug= br.findAll();
		List<Busdetailsdto> uddto=new ArrayList<>();
		for(Busdetails ugr :ug)
		{// TODO Auto-generated method stub
		uddto.add(bb.bus_e_dto(ugr));	
		}
		return uddto;
	}

}
