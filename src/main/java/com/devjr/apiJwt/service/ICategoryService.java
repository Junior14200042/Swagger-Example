package com.devjr.apiJwt.service;

import com.devjr.apiJwt.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAll();

    void saveCategory(Category category);

    Category getById(Long id);

}
