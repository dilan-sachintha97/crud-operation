package com.spark.possystem.service.impl;
import com.spark.possystem.dto.CustomerDTO;
import com.spark.possystem.dto.request.CustomerRequestDTO;
import com.spark.possystem.dto.response.CustomerResponseDTO;
import com.spark.possystem.dto.response.paginate.PaginatedCustomerResponseDTO;
import com.spark.possystem.entity.Customer;
import com.spark.possystem.repo.CustomerRepo;
import com.spark.possystem.service.CustomerService;
import com.spark.possystem.util.IdGenerator;
import com.spark.possystem.util.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

//    @Autowired
//   private CustomerMapper customerMapper;

  @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private IdGenerator idGenerator;


    @Override
    public String saveCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer c1 = new Customer(
                idGenerator.generateID(10),
                customerRequestDTO.getName(),
                customerRequestDTO.getAddress(),
                customerRequestDTO.getSalary()
        );
        customerRepo.save(c1);
        return c1.getId() + " was saved !";
    }

 /*   @Override
    public String saveCustomer(CustomerRequestDTO customerRequestDTO) {
        CustomerDTO customerDTO = new CustomerDTO(
                idGenerator.generateID(10),
                customerRequestDTO.getName(),
                customerRequestDTO.getAddress(),
                customerRequestDTO.getSalary()
        );

        return  customerRepo.save(customerMapper.toCustomer(customerDTO)).getId() + "was saved !";

    }*/

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
           throw new ClassNotFoundException("Not Found");
        }

        return  new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getSalary()
        );
    }

    @Override
    public String updateCustomer(CustomerRequestDTO customerDTO, String id) {
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

    @Override
    public PaginatedCustomerResponseDTO findAllCustomersPaginate(String searchText, int page, int size) {
        return null;
          // create method with a custom query=?  (find data)
          // create method with a custom query=?  (count)
    }
}
