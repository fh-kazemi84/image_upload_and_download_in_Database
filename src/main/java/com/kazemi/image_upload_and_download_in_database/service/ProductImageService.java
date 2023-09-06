package com.kazemi.image_upload_and_download_in_database.service;

import com.kazemi.image_upload_and_download_in_database.dao.ProductImageRepository;
import com.kazemi.image_upload_and_download_in_database.entity.ProductImage;
import com.kazemi.image_upload_and_download_in_database.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * @author fh.kazemi
 **/

@Service
public class ProductImageService {

    @Autowired
    private ProductImageRepository imageRepo;

    public ProductImage uploadImage(MultipartFile file) throws IOException {
        ProductImage pImage = new ProductImage();
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
        return imageRepo.save(pImage);
    }

    public byte[] downloadImage(String fileName){
        Optional<ProductImage> imageData = imageRepo.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }
}
