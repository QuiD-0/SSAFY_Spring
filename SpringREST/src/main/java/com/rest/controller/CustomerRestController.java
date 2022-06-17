package com.rest.controller;


import com.mvc.service.CustomerService;
import com.mvc.vo.Customer;
import lombok.Getter;
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
    public void insert(@RequestBody Customer customer) {
        customerService.insert(customer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> showAll() {
        List<Customer> list = customerService.selectAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<List<Customer>> showAllOrderByName() {
        List<Customer> list = customerService.selectAllOrderByName();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //pk값 만큼 Customer 랜덤 생성
    @GetMapping("/insert/{pk}")
    public ResponseEntity insertRandom(@PathVariable String pk) {
        try {
            for (int i = 0; i < Integer.parseInt(pk); i++) {
                customerService.randomInsert();
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{pk}")
    public Customer showOne(@PathVariable(name = "pk") String pk) {
        return customerService.selectOne(pk);
    }

    @PutMapping
    public int updateUser(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping("/{pk}")
    public void deleteCustomer(@PathVariable(name = "pk") String pk) {
        customerService.delete(pk);
    }

    @GetMapping("/addr/{region}")
    public List<Customer> addrSearch(@PathVariable(name = "region") String region) {
        return customerService.findByAddress(region);
    }


}

