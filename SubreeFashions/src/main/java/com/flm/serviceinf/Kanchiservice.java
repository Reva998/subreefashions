package com.flm.serviceinf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.builder.KanchiBuilder;
import com.flm.dto.Kanchisareesdto;
import com.flm.entity.Kanchisarees;
import com.flm.repo.KanciRepo;
@Service
public class Kanchiservice implements KanchiInf {
@Autowired
private KanciRepo kr;
@Autowired
private KanchiBuilder kb;
private Kanchisarees ks;
private Kanchisareesdto kdto;
	@Override
	public void saveImg(Kanchisareesdto kdto) {
		ks=kb.dto_en_nc(kdto);
		kr.save(ks);// TODO Auto-generated method stub
		
	}

	@Override
	public List<Kanchisareesdto> viewAllkanchi() {
		List<Kanchisarees> ksr=kr.findAll();
		List<Kanchisareesdto> ksdto= new ArrayList();
		for(Kanchisarees kss:ksr)
		{
			ksdto.add(kb.en_dto(kss));
		}
		return ksdto;
	}

}
