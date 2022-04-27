package com.boot_db.mapper;


import com.boot_db.vo.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//client(CustomerServiceImpl.java)
@Mapper
public interface CustomerMapper {
    public List<Customer> selectAll();

    public Customer selectOne(String num);

    public int insert(Customer c);

    public int delete(String num);

    public List<Customer> findByAddress(String address);

    public int update(Customer c);

}





