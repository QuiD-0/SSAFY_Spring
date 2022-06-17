package com.mvc.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
	public void randomInsert() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
		Customer c = new Customer("1",generatedString,generatedString);
		mapper.insert(c);
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







