package com.creathus.teste.controller;

import com.creathus.teste.dto.ProductDto;
import com.creathus.teste.form.ProductForm;
import com.creathus.teste.mapper.ProductMapper;
import com.creathus.teste.model.Product;
import com.creathus.teste.repository.ProductRepository;
import com.creathus.teste.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
	private ProductService productService;
	
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

	@GetMapping("/pageable")
	@ResponseBody
	public Page<ProductDto> findPageable(Pageable pageRequest) {
		Page<Product> entityPage = productService.findPageable(pageRequest);
        List<ProductDto> dtos = ProductMapper.INSTANCE.entityToResponse(entityPage.getContent());
        return new PageImpl<>(dtos, pageRequest, entityPage.getTotalElements());
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
