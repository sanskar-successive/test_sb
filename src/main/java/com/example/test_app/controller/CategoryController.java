package com.example.test_app.controller;

import com.example.test_app.dto.CategoryDTO;
import com.example.test_app.entity.Category;
import com.example.test_app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<CategoryDTO> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryId){
        CategoryDTO updatedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(updatedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categpryId){
        CategoryDTO deletedCategoryDTO = categoryService.deleteCategory(categpryId);
        return new ResponseEntity<>(deletedCategoryDTO, HttpStatus.OK);
    }
}
