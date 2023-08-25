package com.spark.possystem.util.mapper;

import com.spark.possystem.dto.CustomerDTO;
import com.spark.possystem.dto.response.CustomerResponseDTO;
import com.spark.possystem.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(componentModel = "spring" )
public interface CustomerMapper {
    Customer toCustomer(CustomerDTO customerDTO);
    CustomerResponseDTO toCustomerResponseDto (Customer customer);
    List<CustomerResponseDTO> toCustomerResponseDtoList (List<Customer> customerList);
}
