package com.productservice.productservice.thirdpartyclients.fakestoreclient;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Component
public class FakeStoreClientAdapter {
    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private String genericProductsUrl = "https://fakestoreapi.com/products";

    FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        //RestTemplate

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity
                = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);

        //convert FakeStoreProductDto to GenericProductDto
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException("PRoduct is not found");
        }

        return responseEntity.getBody();
        //return "Products fetched with id" + id;
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductsUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> result = new ArrayList<>();
        return List.of(responseEntity.getBody());
    }

    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor
                = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return responseEntity.getBody();
    }

    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(genericProductsUrl, genericProductDto, FakeStoreProductDto.class);

        return responseEntity.getBody();
    }

    public FakeStoreProductDto updateProductById(GenericProductDto genericProductDto) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        System.out.println("I am in update");
        System.out.println(genericProductDto.getId());
        System.out.println((genericProductDto.getTitle()));

        //restTemplate.put(genericProductsUrl + "/" + genericProductDto.getId(), genericProductDto);
        //.put(specificProductUrl, genericProductDto, Map.of("id", genericProductDto.getId()));
        //restTemplate.execute()
        //restTemplate.put();
        //restTemplate.put

       // restTemplate.put(genericProductsUrl, genericProductDto);

        //RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        //ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor
          //      = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        //ResponseEntity<FakeStoreProductDto> responseEntity =
          //      restTemplate.execute(specificProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, genericProductDto);

        //resttemplate.postfor
        //return responseEntity.getBody();

       // RestTemplate restTemplate = restTemplateBuilder.build();
        //ResponseEntity<FakeStoreProductDto> responseEntity =
          //      restTemplate.postForEntity(specificProductUrl, genericProductDto, FakeStoreProductDto.class);
        //restTemplate.exchange(genericProductsUrl + "/" + genericProductDto.getId(), HttpMethod.PUT,
              //  genericProductDto, FakeStoreProductDto.class);
      //  resttemplate.exch


        //RestTemplate restTemplate = restTemplateBuilder.build();

        //RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        //ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor
          //      = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        //ResponseEntity<FakeStoreProductDto> responseEntity =
          //      restTemplate.execute(specificProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, genericProductDto);

        //return responseEntity.getBody();

       // Map<String, String> params = new HashMap<String, String>();
        //params.put("id", String.valueOf(genericProductDto.getId()));
        //Product updated = new Product(genericProductDto.getTitle(), genericProductDto.getDescription(),
          //      genericProductDto.getImage(), new Category(genericProductDto.getCategory()),
            //    new Price(genericProductDto.getPrice()));
       // RestTemplate restTemplate = new RestTemplate();
        //restTemplate.put(genericProductsUrl + "/" + genericProductDto.getId(), updated, params);

        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.exchange(genericProductsUrl + "/" + genericProductDto.getId(), HttpMethod.PUT, new HttpEntity<>(genericProductDto), FakeStoreProductDto.class);
        return responseEntity.getBody();


       // return this.getProductById(genericProductDto.getId());
    }
}
