package com.spark.possystem.service;

import com.spark.possystem.dto.request.CustomerDTO;
import com.spark.possystem.dto.response.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);
    public CustomerResponseDTO findCustomer(String id);
    public String updateCustomer(CustomerDTO customerDTO, String id);
    public String deleteCustomer(String id);
    public List<CustomerResponseDTO> findAllCustomers();
}
