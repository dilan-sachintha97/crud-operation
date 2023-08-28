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

    @Query(value = "SELECT * FROM customer WHERE name LIKE%?1% OR address LIKE%?1%" , nativeQuery = true)
    public List<Customer> searchCustomers(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(id) FROM customer WHERE name LIKE%?1% OR address LIKE%?1%" , nativeQuery = true)
    public int countCustomers(String searchText);

    Optional<Customer> findAllById(String id);
}
