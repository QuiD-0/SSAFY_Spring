package com.mvc.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mapper.CustomerMapper;
import com.mvc.vo.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired 
	CustomerMapper mapper;
	
	@Override
	public List<Customer> selectAll() {
		List<Customer> list = mapper.selectAll();
		Collections.sort(list);
		return list;
	}

	@Override
	public List<Customer> selectAllOrderByName() {
		return mapper.selectAllOrderByName();
	}

	@Override
	public Customer selectOne(String num) {		
		return mapper.selectOne(num);
	}

	@Override
	public int insert(Customer c) {
		return mapper.insert(c);
		
	}

	@Override
	public int delete(String num) {
		int x =  mapper.delete(num);
		return x;
		
	}

	@Override
	public List<Customer> findByAddress(String address) {		
		return mapper.findByAddress(address);
	}

	@Override
	public int update(Customer c) {
		int x = mapper.update(c);
		return x;
		
	}	

}







