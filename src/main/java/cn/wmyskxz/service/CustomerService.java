package cn.wmyskxz.service;

import cn.wmyskxz.entity.Customer;

import java.util.List;

public interface CustomerService {
    int insertCustomer(Customer customer);
    List<Customer> getCustomerList();
    List<Customer> findSpecificCustomer(String identity,String name,String sex,String phone);
    int deleteByIdentity(String identityId);
}
