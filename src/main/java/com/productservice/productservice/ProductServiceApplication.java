package com.productservice.productservice;


import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final PriceRepository priceRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductServiceApplication(PriceRepository priceRepository,
                                     CategoryRepository categoryRepository,
                                     ProductRepository productRepository) {
        this.priceRepository = priceRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
       // Mentor mentor = new Mentor();
        //mentor.setName("Nandkishore");
        //mentor.setEmail("nanduonline@gmail.com");
        //mentor.setAvgRating(80);

        //mentorRepository.save(mentor);



       // Price savedPrice = priceRepository.save(price);

        //Category category = new Category();
        //category.setName("Apple Devices");
        //Category savedCategory = categoryRepository.save(category);

        Price price1 = new Price();
        price1.setCurrency("INR");
        price1.setValue(100000);

        Price price2 = new Price();
        price2.setCurrency("INR");
        price2.setValue(100000);

        Price price3 = new Price();
        price3.setCurrency("INR");
        price3.setValue(100000);

     //   Optional<Price> optionalPrice = priceRepository.findById(UUID.fromString("588e64bd-b96b-454c-9339-aeb58d581241"));

       // if (optionalPrice.isEmpty()) {
         //   throw new Exception("Price object is null");
        //}

        //Price price1 = optionalPrice.get();

        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("61bad309-cbe6-44d6-84d9-c1bef0876d1e"));

        Category savedCategory = optionalCategory.get();


       /*Product product1 = new Product();
        product1.setTitle("iPhone 15 pro max");
        product1.setDescription("Best iPhone ever");
        product1.setImage("IMG");
        product1.setCategory(savedCategory);
        product1.setPrice(price1);

        Product savedProduct = productRepository.save(product1);

        Product product2 = new Product();
        product2.setTitle("iPhone 15 pro max");
        product2.setDescription("Best iPhone ever");
        product2.setImage("IMG");
        product2.setCategory(savedCategory);
        product2.setPrice(price2);

        Product savedProduct2 = productRepository.save(product2);

        Product product3 = new Product();
        product3.setTitle("iPhone 15 pro max");
        product3.setDescription("Best iPhone ever");
        product3.setImage("IMG");
        product3.setCategory(savedCategory);
        product3.setPrice(price3);

        Product savedProduct3 = productRepository.save(product3); */
    }
}
