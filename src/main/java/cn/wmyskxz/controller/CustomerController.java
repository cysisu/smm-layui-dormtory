package cn.wmyskxz.controller;

import cn.wmyskxz.dao.CustomerDao;
import cn.wmyskxz.entity.Customer;
import cn.wmyskxz.entity.Order;
import cn.wmyskxz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        if(customer.getSex().equals("1")){
            customer.setSex("男");
        }
        else{
            customer.setSex("女");
        }
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

    @RequestMapping(value = "/findSpecificCustomer")
    @ResponseBody
    public Map<String, Object> findSpecificCustomer(@RequestParam("identityId") String identityId, @RequestParam("name") String name,@RequestParam("sex") String sex, @RequestParam("phone") String phone , int page, int limit) {
        if(sex.equals("1")){
            sex="男";
        }
        else if(sex.equals("2")){
            sex="女";
        }
        else
            sex="";
        List<Customer> customerList = customerService.findSpecificCustomer(identityId,name,sex,phone);
        System.out.println("查找过findSpecificCustomer");
        System.out.println(customerList);
        int count = customerList.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "");
        map.put("code", 0);
        map.put("count", count);
        map.put("data", customerList);
        System.out.println(map);
        return map;
    }

    @RequestMapping(value = "/{identityId}", method = RequestMethod.DELETE)
    @ResponseBody
    private Map<String, Object> deleteByIdentityId(@PathVariable("identityId") String identityId) {
        System.out.println("是否请求删除过");
        int result = customerService.deleteByIdentity(identityId);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

}
