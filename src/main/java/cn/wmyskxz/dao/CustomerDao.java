package cn.wmyskxz.dao;

import cn.wmyskxz.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {
    List<Customer> customerList(String identity);
    int insertCustomer(Customer customer);
    List<Customer> getCustomerList();
    List<Customer> findSpecificCustomer(@Param("identityId") String identityId,@Param("name") String name,@Param("sex") String sex,@Param("phone") String phone);
    int deleteByIdentity(@Param("identityId")String identityId);
}
