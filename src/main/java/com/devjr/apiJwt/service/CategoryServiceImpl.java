package com.devjr.apiJwt.service;

import com.devjr.apiJwt.exceptions.ResourceNotFoundException;
import com.devjr.apiJwt.model.Category;
import com.devjr.apiJwt.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{

    private final CategoryRepository categoryRepository;

    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }


    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
         categoryRepository.save(category);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Category with ID: "+id+" not found"));
    }
}
