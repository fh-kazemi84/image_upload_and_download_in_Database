package com.kazemi.image_upload_and_download_in_database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author fh.kazemi
 **/

@Entity
@Table(name = "product_image")
@Getter
@Setter
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;
    @Lob
    @Column(name = "image_data")
    private byte[] imageData;

}
