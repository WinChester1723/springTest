package com.example.springTest.service;

import com.example.springTest.dao.repository.CustomerRepo;
import com.example.springTest.mapper.CustomerMapper;
import com.example.springTest.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements CustomerServiceInter{

    private CustomerRepo customerRepo;

    public CustomerServiceImp(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<CustomerDto> getAllCustomerList() {
        var customerEntity = customerRepo.findAll();
        var customerDto = customerEntity.stream()
                .map(CustomerMapper.INSTANCE::entityToDto)
                .collect(Collectors.toList());
        return customerDto;
    }

    @Override
    public CustomerDto getCustomerById(Integer id) {
        var customerEntity = customerRepo.findById(id).orElseThrow();
        return CustomerMapper.INSTANCE.entityToDto(customerEntity);
    }
    @Override

    public void createCustomer(CustomerDto customerDto) {
        var customerEntity = CustomerMapper.INSTANCE.dtoToEntity(customerDto);
        customerRepo.save(customerEntity);
        CustomerMapper.INSTANCE.entityToDto(customerEntity);
    }
    @Override

    public CustomerDto  editCustomer(Integer id, CustomerDto customerDto) {
        var exist = customerRepo.existsById(id);
        if (!exist) {
            throw new RuntimeException("Its Error");
        }
        var customerEntity = CustomerMapper.INSTANCE.dtoToEntity(customerDto);
        customerEntity.setId(id);
        customerEntity.setName(customerDto.getName());
        customerEntity.setSurname(customerDto.getSurname());
        customerEntity.setAge(customerDto.getAge());
        customerRepo.save(customerEntity);
        return CustomerMapper.INSTANCE.entityToDto(customerEntity);
    }

    @Override
    public void deleteById(Integer id) {
        customerRepo.deleteById(id);
    }
}
