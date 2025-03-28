package com.devjr.apiJwt.controller;

import com.devjr.apiJwt.model.Category;
import com.devjr.apiJwt.service.ICategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    CategoryController(ICategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> saveCategory(@RequestBody Category category){

        categoryService.saveCategory(category);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Category> getById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.getById(id),HttpStatus.OK);
    }
}
