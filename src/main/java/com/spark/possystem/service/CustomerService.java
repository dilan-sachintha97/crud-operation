package com.spark.possystem.service;

import com.spark.possystem.dto.request.CustomerRequestDTO;
import com.spark.possystem.dto.response.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerRequestDTO customerDTO);
    public CustomerResponseDTO findCustomer(String id) throws ClassNotFoundException;
    public String updateCustomer(CustomerRequestDTO customerDTO, String id);
    public String deleteCustomer(String id);
    public List<CustomerResponseDTO> findAllCustomers();
}
