package com.flm.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flm.dto.Kanchisareesdto;
import com.flm.entity.Kanchisarees;

@Component
public class KanchiBuilder {

private Kanchisarees ks;

private Kanchisareesdto kdto;
public Kanchisareesdto en_dto(Kanchisarees ks)
{
	kdto=new Kanchisareesdto(ks.getCode(),ks.getImage(),ks.getPrice(),ks.getImgdesc());
	return kdto;
}
public Kanchisarees dto_en(Kanchisareesdto kdto)
{
	ks=new Kanchisarees(kdto.getCode(),kdto.getImage(),kdto.getPrice(),kdto.getImgdesc());
	return ks;
}
public Kanchisareesdto en_dto_nc(Kanchisarees ks)
{
	kdto=new Kanchisareesdto(ks.getImage(),ks.getPrice(),ks.getImgdesc());
	return kdto;
}
public Kanchisarees dto_en_nc(Kanchisareesdto kdto)
{
	ks=new Kanchisarees(kdto.getImage(),kdto.getPrice(),kdto.getImgdesc());
	return ks;
}
}
