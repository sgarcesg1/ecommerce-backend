package com.alguienconoce.ecommerce.service;

import com.alguienconoce.ecommerce.domain.ProductImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class ProductImageService {

    private static final long LARGE_IMAGE_SIZE = 200 * 1000L ; //200kb
    private static final String BACKGROUND_COLOR = "rgb(245,245,245)";

    public ProductImage optimizeAndUpload(MultipartFile file) {

        optimize(null, null, true);

        return ProductImage.builder().build();
    }

    private void optimize(MultipartFile file, ProductImage productImage, boolean reduceQuality) {
        //save File in disk
        //ImageMagickRunner for each desired format
        //Upload  original and results to bucket
    }
}
