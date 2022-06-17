package com.mvc.mapper;

import com.mvc.vo.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

//client(CustomerServiceImpl.java)
public interface CustomerMapper {

    @Select(" select * from customer")
    public List<Customer> selectAll();
    @Select(" select * from customer order by name")
    List<Customer> selectAllOrderByName();

    @Select("select * from customer where num = #{num}")
    public Customer selectOne(@Param("num") String num);

    @Insert("insert into customer values(#{num}, #{name}, #{address}) ")
    public int insert(@Param("c") Customer c);

	@Delete("delete from customer where num = #{num}")
    public int delete(@Param("num") String num);

	@Select("select * from customer where address = #{address}")
    public List<Customer> findByAddress(@Param("address") String address);

	@Update("delete from customer where num = #{num}")
    public int update(@Param("c") Customer c);


}





