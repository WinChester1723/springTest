package com.example.springTest.controller;

import com.example.springTest.model.CustomerDto;
import com.example.springTest.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {

    private CustomerService customerService;

    public MainController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerDto> getCustomers() {
        return customerService.getAllCustomerList();
    }

    @GetMapping("/customers/{id}")
    public CustomerDto getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customers/create")
    public void createCustomers(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
    }

    @PostMapping("/customers/edit/{id}")
    public CustomerDto editCustomers(@PathVariable Integer id,
                                     @RequestBody CustomerDto customerDto){
        return customerService.editCustomer(id,customerDto);
    }

    @PutMapping("/customers/put/edit/{id}")
    public CustomerDto putCustomers(@PathVariable Integer id,
                                    @RequestBody CustomerDto customerDto){
        return customerService.editCustomer(id,customerDto);
    }

    @DeleteMapping("/customers/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        customerService.deleteById(id);
    }
}
