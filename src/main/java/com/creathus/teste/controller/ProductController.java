package com.creathus.teste.controller;

import com.creathus.teste.form.ProductForm;
import com.creathus.teste.model.Product;
import com.creathus.teste.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody ProductForm productForm) {
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        Product productSaved = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id) {
        return productRepository.findById(id)
                .map(record -> {
                    productRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
