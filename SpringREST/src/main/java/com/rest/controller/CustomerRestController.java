package com.rest.controller;


import com.mvc.service.CustomerService;
import com.mvc.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public void insert(@RequestBody Customer customer){
        customerService.insert(customer);
    }

    @GetMapping
    public List<Customer> showAll(){
        return customerService.selectAll();
    }

    @GetMapping("/{pk}")
    public Customer showOne(@PathVariable(name = "pk") String pk){
        return customerService.selectOne(pk);
    }

    @PutMapping
    public int updateUser(@RequestBody Customer customer){
        return customerService.update(customer);
    }

    @DeleteMapping("/{pk}")
    public void deleteCustomer(@PathVariable(name = "pk") String pk){
        customerService.delete(pk);
    }

    @GetMapping("/addr/{region}")
    public List<Customer> addrSearch(@PathVariable(name = "region") String region){
        return customerService.findByAddress(region);
    }

	

}

