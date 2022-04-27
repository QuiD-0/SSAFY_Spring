package com.boot_db.controller;


import com.boot_db.service.CustomerService;
import com.boot_db.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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
    public ResponseEntity<List<Customer>> showAll(){
        List<Customer> list =customerService.selectAll();
        return new ResponseEntity(list, HttpStatus.OK);
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

