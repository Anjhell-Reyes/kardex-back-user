package com.kardex.application.handler.cloudinary;

import org.springframework.web.multipart.MultipartFile;

public interface ICloudinaryHandler {

    String uploadImage(MultipartFile image);

    boolean deleteFileByUrl(String imageUrl);
}
