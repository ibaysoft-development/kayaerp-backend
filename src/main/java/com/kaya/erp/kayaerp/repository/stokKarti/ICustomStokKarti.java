package com.kaya.erp.kayaerp.repository.stokKarti;

import com.kaya.erp.kayaerp.entity.model.StokKarti;


import java.util.List;

public interface ICustomStokKarti {
	
	public List <StokKarti> getStokKartiBysadi (String sadi);
}