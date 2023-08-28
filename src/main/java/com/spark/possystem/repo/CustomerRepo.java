package com.spark.possystem.repo;

import com.spark.possystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = , nativeQuery = true)
    public List<Customer> searchCustomers(String searchText, Pageable pageable);
}
