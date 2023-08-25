package com.spark.possystem.dto.response.paginate;
import com.spark.possystem.dto.response.CustomerResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedCustomerResponseDTO {
    private long dataCount;
    private List<CustomerResponseDTO> dataList;
}
