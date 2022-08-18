package com.example.springTest.controller;

import com.example.springTest.service.CustomerServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web")
public class WebController {

    private CustomerServiceImp customerService;

    public WebController(CustomerServiceImp customerService) {
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
    public String editCustomers(@PathVariable Integer id){
        customerService.getCustomerById(id);
        return "edit_customer";
    }

    @GetMapping("customers/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        customerService.deleteById(id);
        return "redirect:/web/customers";
    }
}
