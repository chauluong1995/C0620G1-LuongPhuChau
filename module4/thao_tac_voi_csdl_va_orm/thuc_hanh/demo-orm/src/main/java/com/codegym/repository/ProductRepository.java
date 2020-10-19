package com.codegym.repository;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(String id);

    void update(Product product);

    void remove(String id);
}
