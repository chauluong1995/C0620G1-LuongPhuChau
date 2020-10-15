package com.codegym.service.impl;

import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Acer Nitro 5", "Yellow", "Acer"));
        products.put(2, new Product(2, "Iphone 12", "Silver", "Iphone"));
        products.put(3, new Product(3, "Nokia 7.2", "Blue", "Nokia"));
        products.put(4, new Product(4, "Realme 5i", "Green", "Realme"));
        products.put(5, new Product(5, "Vsmart Active", "Black", "Vsmart"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {

        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
