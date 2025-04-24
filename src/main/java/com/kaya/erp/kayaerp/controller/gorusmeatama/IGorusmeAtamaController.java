package com.kaya.erp.kayaerp.controller.gorusmeatama;

import com.kaya.erp.kayaerp.entity.model.GorusmeAtama;

public interface IGorusmeAtamaController {

  public GorusmeAtama getGorusmeAtamaById(Integer id);
	
 	public GorusmeAtama getGorusmeAtamaByGid(Integer gid);
}
