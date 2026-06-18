package com.retailtech.api_productos.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.retailtech.api_productos.model.Product;
import com.retailtech.api_productos.repository.ProductRepository;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductRepository repository;

    @Test
    void testGetAllProducts() throws Exception {

        Product mockProduct = new Product(1, "Laptop", 1500.0, 10);

        Mockito.when(repository.findAll())
                .thenReturn(List.of(mockProduct));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk());
    }
}
