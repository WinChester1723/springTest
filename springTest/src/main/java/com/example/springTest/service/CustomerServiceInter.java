package com.example.springTest.service;

import com.example.springTest.model.CustomerDto;

import java.util.List;

public interface CustomerServiceInter {

    public List<CustomerDto> getAllCustomerList();
    public CustomerDto getCustomerById(Integer id);
    public void createCustomer(CustomerDto customerDto);
    public CustomerDto  editCustomer(Integer id, CustomerDto customerDto);
    public void deleteById(Integer id);
}
