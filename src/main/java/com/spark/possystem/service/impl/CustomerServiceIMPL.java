package com.spark.possystem.service.impl;
import com.spark.possystem.dto.request.CustomerDTO;
import com.spark.possystem.dto.response.CustomerResponseDTO;
import com.spark.possystem.entity.Customer;
import com.spark.possystem.repo.CustomerRepo;
import com.spark.possystem.service.CustomerService;
import com.spark.possystem.uti.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private IdGenerator idGenerator;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer c1 = new Customer(
                idGenerator.generateID(10),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getSalary()
        );
        customerRepo.save(c1);
        return c1.getId() + " was saved !";
    }

   /* @Override
    public CustomerResponseDTO findCustomer(String id) {
       Optional<Customer> customer =  customerRepo.findAllById(id);
       if (customer.isPresent()){
           return  new CustomerResponseDTO(
                 customer.get().getId(),
                 customer.get().getName(),
                 customer.get().getAddress(),
                 customer.get().getSalary()
           );
       }
      return null;
    }*/

    @Override
    public CustomerResponseDTO findCustomer(String id) throws ClassNotFoundException {
        Customer customer =  customerRepo.findById(id).orElse(null);

        if (customer ==  null){
           throw new ClassNotFoundException();
        }

        return  new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getSalary()
        );
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO, String id) {
        Customer c = customerRepo.findAllById(id).orElse(null);
        if(null == c) return  "Not Found Customer";

        c.setName(customerDTO.getName());
        c.setAddress(customerDTO.getAddress());
        c.setSalary(customerDTO.getSalary());

        customerRepo.save(c);
        return c.getId() + "was updated successfully";
    }

    @Override
    public String deleteCustomer(String id) {
        Customer c = customerRepo.findAllById(id).orElse(null);
        if(null == c) return  "Not Found Customer";

        customerRepo.deleteById(id);
        return id + " was deleted!";
    }

    @Override
    public List<CustomerResponseDTO> findAllCustomers() {

        List<Customer> allCustomers = customerRepo.findAll();
        List<CustomerResponseDTO> customerResponseDTOList = new ArrayList<>();

        for (Customer c: allCustomers) {
            customerResponseDTOList.add(new CustomerResponseDTO(
                    c.getId(),
                    c.getName(),
                    c.getAddress(),
                    c.getSalary()
            ));
        }
        return customerResponseDTOList;
    }
}
