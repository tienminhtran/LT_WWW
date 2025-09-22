package com.fit.service;

import com.fit.entity.Category;

import java.util.List;

public interface CategoryService {
     public List<Category> getAllCategories();

     public Category getCategoryById(int id);
}
