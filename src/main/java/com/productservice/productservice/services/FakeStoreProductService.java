package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdpartyclients.fakestoreclient.FakeStoreClientAdapter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private FakeStoreClientAdapter fakeStoreAdapter;

    FakeStoreProductService(FakeStoreClientAdapter fakeStoreAdapter) {
        this.fakeStoreAdapter = fakeStoreAdapter;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        //RestTemplate
        return convertToGenericProductDto(fakeStoreAdapter.getProductById(id));
        //return "Products fetched with id" + id;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> result =  fakeStoreAdapter.getAllProducts();
        List<GenericProductDto> output = new ArrayList<>();
        for (FakeStoreProductDto each : result) {
            output.add(convertToGenericProductDto(each));
        }
        return output;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return convertToGenericProductDto(fakeStoreAdapter.deleteProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreAdapter.createProduct(genericProductDto));
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto genericProductDto) throws ProductNotFoundException {

        return convertToGenericProductDto(fakeStoreAdapter.updateProductById(genericProductDto));
    }

    @Override
    public void updateProductById() {

    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto genericProductDto = new GenericProductDto();

        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setImage(fakeStoreProductDto.getImage());

        return genericProductDto;
    }
}
