package com.codegym.service;

import com.codegym.entity.Product;
import com.codegym.entity.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllAndSortByID(Pageable pageable);

    Page<Product> findAllAndSortByName(Pageable pageable);

    Page<Product> findAllAndSortByBirthDay(Pageable pageable);

    Page<Product> findByNameContaining(Pageable pageable, String name);

    Page<Product> findByPriceContaining(Pageable pageable, String price);

    Page<Product> findByNameAndAddressContaining(Pageable pageable, String name, String address);

    Page<Product> findByProductTypeContaining(Pageable pageable, String all);

    Page<Product> findByAllContaining(Pageable pageable, String type, String name, String price);

    void deleteProduct(Integer id);

    void save(Product product);

    List<ProductType> allProductType();

    void update(Product product);

    Product findById(Integer id);
}
