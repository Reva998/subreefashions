package com.flm.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flm.dto.Busdetailsdto;
import com.flm.model.Busdetails;
@Component
public class BusBuilder {

private Busdetails bd;

private Busdetailsdto bdto;
public Busdetailsdto bus_e_dto(Busdetails bd)
{
	bdto=new Busdetailsdto(bd.getBusid(),bd.getSource(),bd.getDestination(),bd.getDate(),bd.getDay(),bd.getArrivaltime(),bd.getDepaturetime(),bd.getVaccancies(),bd.getAmount());
	return bdto;
}
public Busdetails bus_dto_e(Busdetailsdto bdto)
{
	bd=new Busdetails(bdto.getBusid(),bdto.getSource(),bdto.getDestination(),bdto.getDate(),bdto.getDay(),bdto.getArrivaltime(),bdto.getDepaturetime(),bdto.getVaccancies(),bdto.getAmount());
	return bd;
}
}
