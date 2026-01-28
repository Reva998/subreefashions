package com.flm.serviceinf;

import java.util.List;

import com.flm.model.ItemsModel;

public interface ItemsInf {
public void addpro(ItemsModel im);
public void delpro(int code);
public void editpro(int code,ItemsModel im);
public ItemsModel getpro(int code);
public List<ItemsModel> getall();
public int addqun(int qu,int code);
public void updatequn(int qun,int code);
}
