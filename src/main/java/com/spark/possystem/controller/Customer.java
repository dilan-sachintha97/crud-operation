package com.spark.possystem.controller;

import com.spark.possystem.dto.request.CustomerDTO;
import com.spark.possystem.dto.response.CustomerResponseDTO;
import com.spark.possystem.service.CustomerService;
import com.spark.possystem.uti.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class Customer {

    @Autowired
    private CustomerService customerService;

    @PostMapping(
            value = "/save-customer"
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        customerService.saveCustomer(customerDTO),
                        null
                ), HttpStatus.CREATED
        );

    }

    @GetMapping("/find-customer/{id}")   // localhost:8085/api/v1/customer/find-customer/15
    public ResponseEntity<StandardResponse> findCustomer(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        id + " details!",
                        customerService.findCustomer(id)
                ), HttpStatus.OK
        );
    }

    @PutMapping(value = "/update", params = {"id"})  // localhost:8085/api/v1/customer/update?id=15
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerDTO customerDTO, @RequestParam String id){
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        customerService.updateCustomer(customerDTO,id ),
                        null
                ), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/remove/{id}") // localhost:8085/api/v1/customer/remove/15
    public ResponseEntity<StandardResponse> deleteCustomer( @PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                         customerService.deleteCustomer(id),
                        null
                ), HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/list")  // localhost:8085/api/v1/customer/list
    public ResponseEntity<StandardResponse> findAllCustomers(){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        " DATA List",
                        customerService.findAllCustomers()
                ), HttpStatus.OK
        );
    }
}











