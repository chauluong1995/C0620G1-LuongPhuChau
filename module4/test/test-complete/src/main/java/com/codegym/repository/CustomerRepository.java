package com.codegym.repository;

import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Page<Customer> findByNameContaining(Pageable pageable, String name);

    Page<Customer> findByAddressContaining(Pageable pageable, String address);

    @Query(value = "select * from customer where `name` like %?1% or address like %?1% " +
            "or id like %?1%  or birth_day like %?1% or gender like %?1% or email like %?1% " +
            "or salary like %?1%  or id_card like %?1% or phone_number like %?1%", nativeQuery = true)
    Page<Customer> findAllOfMe(Pageable pageable, String all);

    @Query(value = "select * from customer where `name` like %?1% and address like %?2%", nativeQuery = true)
    Page<Customer> findByNameAndAddressContainingOfMe(Pageable pageable, String name, String address);

    @Query(value = "select * from customer group by id order by id", nativeQuery = true)
    Page<Customer> findAllAndSortByID(Pageable pageable);

    @Query(value = "select * from customer group by id order by `name`", nativeQuery = true)
    Page<Customer> findAllAndSortByName(Pageable pageable);

    @Query(value = "select * from customer group by id order by birth_day desc", nativeQuery = true)
    Page<Customer> findAllAndSortByBirthDay(Pageable pageable);
}