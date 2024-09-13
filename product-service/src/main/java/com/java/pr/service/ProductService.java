package com.java.pr.service;

import com.java.pr.dto.ProductRequest;
import com.java.pr.dto.ProductResponse;
import com.java.pr.model.Product;
import com.java.pr.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class ProductService {

    @Autowired
    private  ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {0} has been saved successfully"+product.getId());
    }

    public List<ProductResponse> getAllProducts() {

        List<Product> products = productRepository.findAll();
        //return products.stream().map(product -> mapToProductResponse(product)).toList();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
