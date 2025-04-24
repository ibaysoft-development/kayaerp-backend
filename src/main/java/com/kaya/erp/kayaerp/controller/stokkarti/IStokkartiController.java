package com.kaya.erp.kayaerp.controller.stokkarti;

import java.util.List;


import com.kaya.erp.kayaerp.entity.model.StokKarti;

public interface IStokkartiController {

	
	//public List<Stok> getAllStok();
	//public Stok getStokByIdStok(Integer id);
	//public Stok getStokByStokName(String stok_name);
	
      public List <StokKarti> getAllStokKarti();
      public StokKarti getStokKartiByIdStokKarti(Integer sid);
      public List<StokKarti> getStokKartiBysadi(String sadi);
}
