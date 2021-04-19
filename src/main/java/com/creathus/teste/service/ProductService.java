package com.creathus.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.creathus.teste.model.Product;
import com.creathus.teste.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> findPageable(Pageable pageable) {
        return productRepository
                .findAll(pageable);
    }
	
}
