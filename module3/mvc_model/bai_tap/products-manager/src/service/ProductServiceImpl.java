package service;

import model.Product;

import java.util.*;

public class ProductServiceImpl implements ProductService {
    private static Map<String, Product> products;

    static {
        products = new TreeMap<>();
        products.put("VJ5", new Product("VJ5", "Vsmart Joy 5", "500 $", "Nice", "Vsmart"));
        products.put("No7.2", new Product("No7.2", "Nokia 7.2", "350 $", "Nice", "Nokia"));
        products.put("RM5iP", new Product("RM5iP", "Realme 5i Plus", "250 $", "Nice", "Realme"));
        products.put("SN10P", new Product("SN10P", "Samsung Note 10 Plus", "750 $", "Nice", "Samsung"));
        products.put("IPX", new Product("IPX", "Iphone X", "1500 $", "Nice", "Iphone"));
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
    public Product findById(String id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            if (entry.getValue().getName().equals(name)){
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void update(String id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(String id) {
        products.remove(id);
    }
}
