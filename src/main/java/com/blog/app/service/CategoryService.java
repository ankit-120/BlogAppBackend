package com.blog.app.service;

import com.blog.app.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    //add category
    CategoryDto addCategory(CategoryDto categoryDto);

    //get category
    CategoryDto getCategory(int categoryId);

    //get all category
    List<CategoryDto> getAllCategory();

    //update category
    CategoryDto updateCategory(CategoryDto categoryDto,int categoryId);

    //delete category
    void deleteCategory(int categoryId);

}
