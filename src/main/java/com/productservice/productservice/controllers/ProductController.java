package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.ExceptionDto;
import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        // call FakeStoreProductService api getProductById
        //return "Product fetched with id" + id;
        return productService.getProductById(id);
    }

    @GetMapping("")
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id) {

        return  productService.deleteProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
        return productService.createProduct(genericProductDto);
    }

    @PutMapping("/{id}")
    public GenericProductDto updateProductById(@RequestBody GenericProductDto genericProductDto) throws ProductNotFoundException {
        return productService.updateProductById(genericProductDto);
    }

    //@ExceptionHandler(ProductNotFoundException.class)
    //private ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
      //  ExceptionDto exceptionDto = new ExceptionDto();
        //exceptionDto.setMessage(productNotFoundException.getMessage());
        //exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        //return exceptionDto;
        //System.out.println("Got product not found exception");
    //}

}
