package com.kaya.erp.kayaerp.service.gorusmeatama;

import com.kaya.erp.kayaerp.entity.model.GorusmeAtama;

public interface IGorusmeAtamaService {
	
	public GorusmeAtama getGorusmeAtamaById(Integer id);
	
    public	GorusmeAtama getGorusmeAtamaByGid(Integer gid);

}
