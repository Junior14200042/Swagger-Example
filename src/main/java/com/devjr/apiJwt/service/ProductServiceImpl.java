package com.devjr.apiJwt.service;

import com.devjr.apiJwt.model.Category;
import com.devjr.apiJwt.model.Product;
import com.devjr.apiJwt.repository.CategoryRepository;
import com.devjr.apiJwt.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {

        Category category = categoryRepository.findById(product.getCategory().getId())
                        .orElseThrow(()->new RuntimeException("category not found"));

        product.setCategory(category);

        productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        Optional<Product> productExist = productRepository.findById(id);

        if(productExist.isPresent()){
            Product p = productExist.get();
            p.setName(product.getName());
            p.setDescription(product.getDescription());
            p.setPrice(product.getPrice());
            p.setQuantity(product.getQuantity());
            p.setCategory(product.getCategory());

            return productRepository.save(p);
        }

        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
