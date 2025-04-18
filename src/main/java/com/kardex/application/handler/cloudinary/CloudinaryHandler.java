package com.kardex.application.handler.cloudinary;

import com.kardex.domain.spi.IImagePersistencePort;
import com.kardex.domain.exception.URLCloudinayInvalidException;
import com.kardex.domain.exception.UploadImageCloudinaryException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class CloudinaryHandler implements ICloudinaryHandler {

    private final IImagePersistencePort imageServicePort;

    @Override
    public String uploadImage(MultipartFile image) {
        try{
            byte[] file  = image.getBytes();
            return imageServicePort.uploadFile(file);
        }catch (IOException e){
            throw new UploadImageCloudinaryException();
        }
    }

    @Override
    public boolean deleteFileByUrl(String imageUrl) {
        String publicId = extractFileId(imageUrl);
        return imageServicePort.deleteFileByUrl(publicId);
    }

    private String extractFileId(String url) {
        System.out.println(url);
        String regex = "https?://res.cloudinary.com/[^/]+/image/upload/([^?]+)";
        if (url.matches(regex)) {
            return url.replaceAll(regex, "$1");
        }
        throw new URLCloudinayInvalidException();
    }

}
