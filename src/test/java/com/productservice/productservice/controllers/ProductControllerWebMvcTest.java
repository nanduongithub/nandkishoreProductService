package com.productservice.productservice.controllers;

import com.productservice.productservice.models.Product;
import com.productservice.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {

    @MockBean
    private ProductService productService;

    @Inject
    private MockMvc mockMvc;

    @Test
    void testGetAllProductReturnsEmptyList() throws Exception {
        when(productService.getAllProducts()).thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().is(200)).andExpect(content().string("[]"));
    }
}
