package com.kaya.erp.kayaerp.controller.sayfa;

import java.util.List;

import com.kaya.erp.kayaerp.entity.dto.DtoPageByPermittedRole;
import com.kaya.erp.kayaerp.entity.model.Sayfa;

public interface ISayfaController {
	
	public List<Sayfa> getPagesPermittedUser(int user_id);
	 
	 public  List<Sayfa>  getAllPages();
	 
	 public  List<Sayfa>  getPagesByPermittedRole(int role_id);
	 
	 
	 public  List<DtoPageByPermittedRole>  getDtoPagesByPermittedRole(int role_id);
	 
	 public  List<DtoPageByPermittedRole>  saveAndDeletePagesByDtoPermittedRole(List<DtoPageByPermittedRole>  dtoPages,int role_id);

}
