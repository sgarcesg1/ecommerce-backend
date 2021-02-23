package com.alguienconoce.ecommerce.service;

import com.alguienconoce.ecommerce.domain.Product;
import com.alguienconoce.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Optional<Product> getProduct(UUID id) {
        return repository.findById(id);
    }

    public Page<Product> getProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
