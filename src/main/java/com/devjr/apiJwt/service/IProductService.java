package com.devjr.apiJwt.service;

import com.devjr.apiJwt.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAll();

    void saveProduct(Product product);

    Product getById(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
