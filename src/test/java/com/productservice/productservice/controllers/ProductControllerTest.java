package com.productservice.productservice.controllers;

import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import com.productservice.productservice.thirdpartyclients.fakestoreclient.FakeStoreClientAdapter;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Inject
    private FakeStoreClientAdapter fakeStoreClientAdapter;
  //  ProductControllerTest (ProductController productController) {
    //    this.productController = productController;
    //}

    @MockBean
    private ProductService productService;

    @Test
    @DisplayName("Testing one plus one is two")
    void testOnePlusOneTwo() {
        assert(2 == 1+1);
    }

    @Test
    void testGetProductByIdNegativeTc() throws ProductNotFoundException {
        assertThrows(ProductNotFoundException.class,()-> fakeStoreClientAdapter.getProductById(1000L));
        //productController.getProductById(1000L);
        //assertThrows()
    }

    @Test
    void testGetProductByIdMocking() throws ProductNotFoundException {
        when(productService.getProductById(100L)).thenReturn(null);
        assertThrows(ProductNotFoundException.class,()-> fakeStoreClientAdapter.getProductById(1000L));
        //productController.getProductById(1000L);
        //assertThrows()
    }

}

