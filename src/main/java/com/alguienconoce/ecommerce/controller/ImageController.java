package com.alguienconoce.ecommerce.controller;

import com.alguienconoce.ecommerce.domain.ProductImage;
import com.alguienconoce.ecommerce.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/product-images")
@RestController
public class ImageController {

    @Autowired
    private ProductImageService productImageService;

    @PostMapping
    public ProductImage handleFileUpload(@RequestParam("file") MultipartFile file) {
        ProductImage productImage = productImageService.optimizeAndUpload(file);
        return productImage;
    }
}
