package com.creathus.teste.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.creathus.teste.dto.ProductDto;
import com.creathus.teste.model.Product;

@Mapper
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    List<ProductDto> entityToResponse(List<Product> product);

    @InheritInverseConfiguration
    ProductDto entityToResponse(Product product);
}
