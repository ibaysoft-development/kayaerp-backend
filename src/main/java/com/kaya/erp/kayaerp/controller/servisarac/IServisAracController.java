package com.kaya.erp.kayaerp.controller.servisarac;

import java.util.List;

import com.kaya.erp.kayaerp.entity.dto.DtoServisAracFilter;
import com.kaya.erp.kayaerp.entity.model.ServisArac;

public interface IServisAracController {


      public List <ServisArac> getAllServisArac();
      public ServisArac getServisAracByIdServisArac(Long ARACID);
      public List<ServisArac> getServisAracByMARKA(String MARKA);
      public List<ServisArac> getServisAracByMODEL(String MODEL);
      public List<ServisArac> getServisAracByPLAKA(String PLAKA);
      public ServisArac getServisAracBySASI(String SASI);
      public List<ServisArac> getServisAracByEKLENMETARIHI(String bastar , String bittar);
      public ServisArac addServisArac(ServisArac servisArac);
      public List <ServisArac> addServisAracList(List <ServisArac> servisAracList);
      public void deleteServisArac(Long ARACID);
      public List<ServisArac> getServisAracByDtoServiceAracFilter(DtoServisAracFilter filter);
}
