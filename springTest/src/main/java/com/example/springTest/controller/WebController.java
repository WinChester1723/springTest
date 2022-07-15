package com.example.springTest.controller;

import com.example.springTest.model.CustomerDto;
import com.example.springTest.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web")
public class WebController {

    private CustomerService customerService;

    public WebController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        model.addAttribute("customers",customerService.getAllCustomerList());
        return "customers";
    }

    @GetMapping("/customers/new")
    public String createCustomer(){
        return "create_customer";
    }

    @GetMapping("/customers/edit/{id}")
    public String editCustomers(@PathVariable Integer id,
                                CustomerDto customerDto){
        customerService.editCustomer(id, customerDto);
        return "redirect:/web/customers";
    }

}
