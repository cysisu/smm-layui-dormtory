package cn.wmyskxz.service.impl;

import cn.wmyskxz.dao.CustomerDao;
import cn.wmyskxz.entity.Customer;
import cn.wmyskxz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    public int insertCustomer(Customer customer){
        List<Customer> customerList= customerDao.customerList(customer.getIdentityId());
        if(customerList.size()>0){
            return -1;
        }
        else{
            return customerDao.insertCustomer(customer);
        }
    }

    public List<Customer> getCustomerList(){
        return customerDao.getCustomerList();
    }
}
