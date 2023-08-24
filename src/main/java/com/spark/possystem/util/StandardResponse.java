package com.spark.possystem.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {
    int code; //http response code
    private String message;
    private Object data;
}
