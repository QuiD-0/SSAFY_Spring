package com.mvc.mapper;

import java.util.List;

import com.mvc.vo.Customer;

//client(CustomerServiceImpl.java)
public interface CustomerMapper {
	public List<Customer> selectAll();
	public Customer selectOne(String num);
	public int insert(Customer c);
	
	public int delete(String num);
	public List<Customer> findByAddress(String address);
	public int update(Customer c);
	
}





