package com.spark.possystem.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerResponseDTO {
    private String id;
    private String name;
    private String address;
    private double salary;
}
