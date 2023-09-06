package com.kazemi.image_upload_and_download_in_database.dao;

import com.kazemi.image_upload_and_download_in_database.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author fh.kazemi
 **/

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    Optional<ProductImage> findByName(String fileName);
}
