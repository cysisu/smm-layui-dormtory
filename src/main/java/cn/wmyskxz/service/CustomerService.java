package cn.wmyskxz.service;

import cn.wmyskxz.entity.Customer;

import java.util.List;

public interface CustomerService {
    int insertCustomer(Customer customer);
    List<Customer> getCustomerList();
}
