package com.kosa.myapp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadDTO {
	private String id;
	private String name;
	private MultipartFile[] file;
}
