package com.kaya.erp.kayaerp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoImageUploadRequest {

		private String base64Image;
	    private String fileName;
	    private String type;
	    private String sasi;
	
	  
}
