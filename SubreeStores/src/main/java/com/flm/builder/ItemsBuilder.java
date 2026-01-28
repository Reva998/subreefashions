package com.flm.builder;

import org.springframework.stereotype.Component;

import com.flm.entity.Items;
import com.flm.model.ItemsModel;

@Component
public class ItemsBuilder
{
	private ItemsModel im;
	private Items it;
	public Items im_it(ItemsModel itm)
	{
		it=new Items(itm.getCode(),itm.getProname(),itm.getRate(),itm.getGst(),itm.getTotal_quantity(),itm.getSupplier(),itm.getSupplier_add(),itm.getQuantity_per());
	return it;
	}
	public ItemsModel it_im(Items itm)
	{
		im=new ItemsModel(itm.getCode(),itm.getProname(),itm.getRate(),itm.getGst(),itm.getTotal_quantity(),itm.getSupplier(),itm.getSupplier_add(),itm.getQuantity_per());
	return im;
	}
}