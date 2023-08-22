package com.spark.possystem.repo;

import com.spark.possystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,String> {

    Optional<Customer> findAllById(String id);
}
