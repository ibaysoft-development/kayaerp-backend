package com.kaya.erp.kayaerp.service.gorusme;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kaya.erp.kayaerp.entity.dto.DtoGorusmeFilter;
import com.kaya.erp.kayaerp.entity.model.Gorusme;
import com.kaya.erp.kayaerp.repository.gorusme.GorusmeJpa;

@Service
public class GorusmeServiceImpl implements IGorusmeService {

	@Autowired
	private GorusmeJpa gorusmeRepository;

	@Override
	public List<Gorusme> getAllGorusme() {

		return gorusmeRepository.findAll();
	}

	@Override
	public Gorusme getGorusmeByIdGorusme(Integer gid) {

		if (gid != null) {

			Optional<Gorusme> gorusmeOptional = gorusmeRepository.findById(gid);

			if (gorusmeOptional.isPresent()) {

				return gorusmeOptional.get();
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gorusme Bulunamadı: ID = " + gid);
		} else {

			throw new IllegalArgumentException("Gorusme Id Giriniz!");
		}
		
		
	}

	@Override
	public List<Gorusme> getGorusmeByGorusmeUsername(String gusername) {
		
		return gorusmeRepository.getGorusmeByGorusmeUsername(gusername);
	}

     @Override
     public Gorusme addGorusme (Gorusme gorusme) {
    	 if (gorusme == null) {
 			throw new IllegalArgumentException("Gorusme  Giriniz!");
 		}
    	 Gorusme eklenenGorusme = new Gorusme ();
    	 try {
    		 eklenenGorusme = gorusmeRepository.save(gorusme);
    	 } catch  (Exception e) {
 			String exeptionString = e.getMessage();
    	 }
    	 return eklenenGorusme;
     }
     
     public List<Gorusme>  addGorusmeList(List <Gorusme>  gorusmeList) {
    	 return gorusmeRepository.saveAll(gorusmeList);
     }
	
     public void deleteGorusme (Integer gid) {
    	 
    	 Optional<Gorusme> gorusme  = gorusmeRepository.findById(gid);
    	 
    	 if (gorusme.isPresent()) {
    		 
    		 try {
    			 gorusmeRepository.deleteById(gid);
    		 }  catch (Exception e) {

 				throw new IllegalArgumentException(e.getMessage());
    	     }
          }else {
        	  throw new  IllegalArgumentException("Gorusme bulunamadı!");
        	  
    		 
    	 }
     }

	@Override
	public List<Gorusme> getGorusmeByFilterDto(DtoGorusmeFilter filter) {
		  return gorusmeRepository.getGorusmeByFilter(filter);
	}
		
	



}