package cn.wmyskxz.controller;

import cn.wmyskxz.dao.CustomerDao;
import cn.wmyskxz.entity.Customer;
import cn.wmyskxz.entity.Order;
import cn.wmyskxz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/insert")
    @ResponseBody
    public Map<String, Object> insertCustomer(@RequestBody Customer customer){
        int result= customerService.insertCustomer(customer);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status",result);
        return map;
    }

    @RequestMapping(value="/getCustomers", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getCustomers(){
        List<Customer> customerList = customerService.getCustomerList();
        System.out.println("返回数据个数:"+customerList.size());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", customerList.size());
        map.put("data", customerList);
        return map;
    }

}
