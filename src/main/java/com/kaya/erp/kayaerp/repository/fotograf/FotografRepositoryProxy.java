package com.kaya.erp.kayaerp.repository.fotograf;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.kaya.erp.kayaerp.entity.dto.DtoImageInfo;
import com.kaya.erp.kayaerp.entity.dto.DtoImageUploadRequest;
import com.kaya.erp.kayaerp.entity.model.Fotograf;
import com.kaya.erp.kayaerp.service.fotograf.PhotoServiceClient;
import com.kaya.erp.kayaerp.util.AppUtil;

@Repository
public class FotografRepositoryProxy {

	private final PhotoServiceClient client;

	public FotografRepositoryProxy(PhotoServiceClient client) {
		this.client = client;
	}

	public List<Fotograf> findAll() {
		List<DtoImageInfo> dtoList = client.getAllImages();
		return dtoList.stream().map(dto -> AppUtil.mapToFotograf( dto, dto.getFileName().split("-")[0],
				dto.getFileName().split("-")[1], dto.getFileName(),AppUtil.parseDateFromStringToDateForPhotos( dto.getFileName().split("-")[3] )  )).collect(Collectors.toList());
	}

	public List<Fotograf> search(String query) {
		return client
				.searchImages(query).stream().map(dto -> new Fotograf(0, dto.getFileName().split("-")[0],
						dto.getFileName().split("-")[1], dto.getFileName(), dto.getFilePath(),null))
				.collect(Collectors.toList());
	}

	public String uploadBase64Image(String base64Image, String fileName) {
		DtoImageUploadRequest request = new DtoImageUploadRequest();
		request.setBase64Image(base64Image);
		request.setFileName(fileName);
		return client.uploadImage(request);
	}

	public String getImagePath(String fileName) {
		return client.getImagePath(fileName);
	}
	
	public String deleteImage(String fileName) {
		return client.deleteImagePath(fileName);
	}
	
	
	
}