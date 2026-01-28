package com.flm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.builder.ItemsBuilder;
import com.flm.entity.Items;
import com.flm.model.ItemsModel;
import com.flm.repo.ItemsRepo;
import com.flm.serviceinf.ItemsInf;
@Service

public class ItemsImp implements ItemsInf{
private ItemsModel imo;
private Items itm;
@Autowired
private ItemsBuilder ib;
@Autowired
private ItemsRepo ir;
	@Override
	public void addpro(ItemsModel im) {
	itm=ib.im_it(im);	// TODO Auto-generated method stub
	ir.save(itm);	
	}

	@Override
	public void delpro(int code) {
		imo=getpro(code);// TODO Auto-generated method stub
		if(imo!=null)
		{
		ir.deleteById(code);	
		}else
		{
			System.out.println("not found");
		}
	}

	@Override
	public void editpro(int code, ItemsModel im) {
	imo=getpro(code);
	if(imo!=null)
	{
		int row=ir.updatePro(im.getProname(), im.getRate(), im.getGst(), im.getTotal_quantity(), im.getSupplier(),im.getSupplier_add(),im.getQuantity_per(),code);
	if(row>0)
	{
		System.out.println("updation success");
	}
	else
	{
		System.out.println("updation not success");	
	}
	}
	else
	{
		System.out.println("no such product found");
	}
	}

	@Override
	public ItemsModel getpro(int code) {
		Optional<Items> its=ir.findById(code);
		if(its.isPresent())
		{
			imo=ib.it_im(its.get());
			return imo;
		}
		else
		{
			System.out.println("not found");
			return null;
		}
		
	}

	@Override
	public List<ItemsModel> getall() {
		List<Items> itms= ir.findAll();
		List<ItemsModel> itmall=new ArrayList();
		for(Items ite: itms)// TODO Auto-generated method stub
		
		{
			itmall.add(ib.it_im(ite));
		}
		return itmall;
	}

	@Override
	public int addqun(int qu, int code) {
		// TODO Auto-generated method stub
		imo=getpro(code);
		int valu=imo.getRate()*qu;
		return valu;
	}

	@Override
	public void updatequn(int qun,int code) {
		imo=getpro(code);// TODO Auto-generated method stub
		if(imo!=null)
		{
			int tq= imo.getTotal_quantity()-qun;
			ir.updatequn(tq, code);
		}else
		{
			System.out.println("not found");
		}
	}

}
