package bo;

import model.Product;

import java.util.List;

public interface ProductBO {
    List<Product> findAll();

    void save(Product product);

    Product findById(String id);

    List<Product> findByName(String name);

    void update(String id, Product product);

    void remove(String id);
}
