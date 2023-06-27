package com.example.demo.map;

import com.example.demo.dto.ProductRequest;
import com.example.demo.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product mapToEntity(ProductRequest productRequest);
    ProductRequest mapToDto(Product product);
}
