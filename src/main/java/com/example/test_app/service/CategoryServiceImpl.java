package com.example.test_app.service;

import com.example.test_app.dto.CategoryDTO;
import com.example.test_app.dto.CategoryResponse;
import com.example.test_app.entity.Category;
import com.example.test_app.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService  {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override

    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> allCategories = categoryRepository.findAll().stream().map((category)-> modelMapper.map(category, CategoryDTO.class)).toList();
        return allCategories;
    }
//    public CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
//        return null;
//    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category categoryFromDb = categoryRepository.findByCategoryName(category.getCategoryName());
        if (categoryFromDb!=null){
            System.out.println("category already exist");
        }

        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow();
        Category categoryToUpdate = modelMapper.map(categoryDTO, Category.class);
        categoryToUpdate.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(categoryToUpdate);
        return  modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {
        Category categoryInDb = categoryRepository.findById(categoryId).orElseThrow();
        categoryRepository.delete(categoryInDb);
        return modelMapper.map(categoryInDb, CategoryDTO.class);
    }
}

