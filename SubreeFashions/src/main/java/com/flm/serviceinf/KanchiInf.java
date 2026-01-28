package com.flm.serviceinf;

import java.util.List;

import com.flm.dto.Kanchisareesdto;

public interface KanchiInf {
public void saveImg(Kanchisareesdto kdto);
public List<Kanchisareesdto> viewAllkanchi();
}
