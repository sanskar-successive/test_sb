package com.example.test_app.service;

import com.example.test_app.dto.CategoryDTO;
import com.example.test_app.dto.CategoryResponse;
import java.util.List;


public interface CategoryService {

//    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    List<CategoryDTO> getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
    CategoryDTO deleteCategory(Long categoryId);
}
