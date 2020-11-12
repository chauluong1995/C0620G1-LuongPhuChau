package com.codegym.service;

import com.codegym.entity.Product;
import com.codegym.entity.ProductType;
import com.codegym.repository.ProductRepository;
import com.codegym.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findAllAndSortByID(Pageable pageable) {
        return this.productRepository.findAllAndSortByID(pageable);
    }

    @Override
    public Page<Product> findAllAndSortByName(Pageable pageable) {
        return this.productRepository.findAllAndSortByName(pageable);
    }

    @Override
    public Page<Product> findAllAndSortByBirthDay(Pageable pageable) {
        return this.productRepository.findAllAndSortByBirthDay(pageable);
    }

    @Override
    public Page<Product> findByNameContaining(Pageable pageable, String name) {
        return this.productRepository.findByNameContaining(pageable, name);
    }

    @Override
    public Page<Product> findByPriceContaining(Pageable pageable, String price) {
        return this.productRepository.findByPriceContaining(pageable, price);
    }

    @Override
    public Page<Product> findByNameAndAddressContaining(Pageable pageable, String name, String address) {
        return this.productRepository.findByNameAndAddressContainingOfMe(pageable, name, address);
    }

    @Override
    public Page<Product> findByProductTypeContaining(Pageable pageable, String all) {
        return this.productRepository.findByProductTypeContaining(pageable, all);
    }

    @Override
    public Page<Product> findByAllContaining(Pageable pageable, String type, String name, String price) {
        return this.productRepository.findByAllContaining(pageable, type, name, price);
    }

//    @Override
//    public Page<Product> findAllOfMe(Pageable pageable, String all) {
//        return this.productRepository.findAllOfMe(pageable, all);
//    }

    @Override
    public void deleteProduct(Integer id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public void save(Product customer) {
        this.productRepository.save(customer);
    }

    @Override
    public List<ProductType> allProductType() {
        return this.productTypeRepository.findAll();
    }

    @Override
    public void update(Product customer) {
        this.productRepository.save(customer);
    }

    @Override
    public Product findById(Integer id) {
        return this.productRepository.findById(id).orElse(null);
    }
}
