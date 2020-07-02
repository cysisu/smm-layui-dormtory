package cn.wmyskxz.dao;

import cn.wmyskxz.entity.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> customerList(String identity);
    int insertCustomer(Customer customer);
    List<Customer> getCustomerList();
}
