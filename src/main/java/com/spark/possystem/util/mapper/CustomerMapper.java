package com.spark.possystem.util.mapper;

import com.spark.possystem.dto.request.CustomerRequestDTO;
import com.spark.possystem.dto.response.CustomerResponseDTO;
import com.spark.possystem.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomer(CustomerRequestDTO customerDTO);
    CustomerResponseDTO toCustomerResponseDto (Customer customer);
    List<CustomerResponseDTO> toCustomerResponseDtoList (List<Customer> customerList);
}