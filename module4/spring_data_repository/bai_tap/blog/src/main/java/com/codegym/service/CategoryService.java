package com.codegym.service;

import com.codegym.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(String id);

    void save(Category category);

    void edit(Category category);

    void delete(String id);
}
