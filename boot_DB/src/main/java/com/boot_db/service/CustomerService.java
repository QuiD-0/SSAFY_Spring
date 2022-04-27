package com.boot_db.service;


import com.boot_db.vo.Customer;

import java.util.List;

//client(CustomerApp.java)
public interface CustomerService {
	public List<Customer> selectAll();
	public Customer selectOne(String num);
	public int insert(Customer c);	
	
	public int delete(String num);
	public List<Customer> findByAddress(String address);
	public int update(Customer c);	
}





