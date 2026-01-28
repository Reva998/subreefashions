package com.flm.service;

import java.util.List;

import com.flm.dto.Busdetailsdto;

public interface BusInf {
public boolean saveBus(Busdetailsdto bdto);
public boolean editBus(String id,Busdetailsdto bdto);
public void deleteBus(String id);
public Busdetailsdto getBus(String id);
public List<Busdetailsdto> getAllBus();

}
