package com.codegym.repository;

import com.codegym.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByNameContaining(Pageable pageable, String name);

    @Query(value = "select * from product where price like %?1%", nativeQuery = true)
    Page<Product> findByPriceContaining(Pageable pageable, String all);

    @Query(value = "select * from product where product_type_id like %?1%", nativeQuery = true)
    Page<Product> findByProductTypeContaining(Pageable pageable, String all);

    @Query(value = "select * from product where `name` like %?1% and price like %?2%", nativeQuery = true)
    Page<Product> findByNameAndAddressContainingOfMe(Pageable pageable, String name, String address);

    @Query(value = "select * from product where product_type_id like %?1% and `name` like %?2% and price like %?3%",
            nativeQuery = true)
    Page<Product> findByAllContaining(Pageable pageable, String type, String name, String price);

    @Query(value = "select * from product group by id order by id", nativeQuery = true)
    Page<Product> findAllAndSortByID(Pageable pageable);

    @Query(value = "select * from product group by id order by `name`", nativeQuery = true)
    Page<Product> findAllAndSortByName(Pageable pageable);

    @Query(value = "select * from product group by id order by price desc", nativeQuery = true)
    Page<Product> findAllAndSortByBirthDay(Pageable pageable);
}
