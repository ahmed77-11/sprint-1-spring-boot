package com.ahmed.motos.service;

import com.ahmed.motos.entities.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface ImageService {
    Image uploadImage(MultipartFile file) throws IOException;
    Image getImageDetails(Long id) throws IOException;
    ResponseEntity<byte[]> getImage(Long id) throws IOException;
    void deleteImage(Long id);
    Image uploadImageMoto(MultipartFile file,Long idMoto) throws IOException;
    List<Image> getImagesParProd(Long motoId);
}
