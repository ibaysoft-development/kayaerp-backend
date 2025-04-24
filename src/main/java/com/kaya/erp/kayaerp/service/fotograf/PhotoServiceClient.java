package com.kaya.erp.kayaerp.service.fotograf;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import com.kaya.erp.kayaerp.entity.dto.DtoImageDeleteResponse;
import com.kaya.erp.kayaerp.entity.dto.DtoImageInfo;
import com.kaya.erp.kayaerp.entity.dto.DtoImagePathResponse;
import com.kaya.erp.kayaerp.entity.dto.DtoImageUploadRequest;
import com.kaya.erp.kayaerp.entity.dto.DtoImageUploadResponse;

@Service
public class PhotoServiceClient {

	 private final RestTemplate restTemplate;

	    @Value("${photoservice.url}")
	    private String photoServiceBaseUrl;

	    public PhotoServiceClient(RestTemplateBuilder builder) {
	        this.restTemplate = builder.build();
	    }

	    public List<DtoImageInfo> getAllImages() {
	        String url = photoServiceBaseUrl + "/Images/all";
	        ResponseEntity<DtoImageInfo[]> response = restTemplate.getForEntity(url, DtoImageInfo[].class);
	        return Arrays.asList(Objects.requireNonNull(response.getBody()));
	    }
	    
	    public List<DtoImageInfo> searchImages(String query) {
	        String url = photoServiceBaseUrl + "/Images/search?query=" + UriUtils.encode(query, StandardCharsets.UTF_8);
	        ResponseEntity<DtoImageInfo[]> response = restTemplate.getForEntity(url, DtoImageInfo[].class);
	        return Arrays.asList(Objects.requireNonNull(response.getBody()));
	    }

	    public String getImagePath(String fileName) {
	        String url = photoServiceBaseUrl + "/Images/getpath/" + UriUtils.encodePathSegment(fileName, StandardCharsets.UTF_8);
	        ResponseEntity<DtoImagePathResponse> response = restTemplate.getForEntity(url, DtoImagePathResponse.class);
	        return Objects.requireNonNull(response.getBody()).getFileUrl();
	    }
	    
	    
	    public String deleteImagePath(String fileName) {
	        String url = photoServiceBaseUrl + "/Images/delete/" + UriUtils.encodePathSegment(fileName, StandardCharsets.UTF_8);
	        ResponseEntity<DtoImageDeleteResponse> response = restTemplate.getForEntity(url, DtoImageDeleteResponse.class);
	        return Objects.requireNonNull(response.getBody()).getMessage();
	    }

	    public String uploadImage(DtoImageUploadRequest request) {
	        String url = photoServiceBaseUrl + "/Images/upload";
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<DtoImageUploadRequest> entity = new HttpEntity<>(request, headers);
              
	        try {
	            // Başarılıysa doğrudan DTO döner
	            DtoImageUploadResponse dto = restTemplate.postForObject(url, entity, DtoImageUploadResponse.class);
	            return Objects.requireNonNull(dto).getFileUrl();

	        } catch (HttpClientErrorException e) {
	            if (e.getStatusCode() == HttpStatus.CONFLICT) {
	                return "Var Olan Fotograf";
	            } else {
	                throw new RuntimeException("İstemci hatası: " + e.getStatusCode());
	            }

	        } catch (HttpServerErrorException e) {
	            throw new RuntimeException("Sunucu hatası: " + e.getStatusCode());

	        } catch (RestClientException e) {
	            throw new RuntimeException("Bağlantı hatası: " + e.getMessage());
	        }
	    }
}
