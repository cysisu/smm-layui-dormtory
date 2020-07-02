package cn.wmyskxz.controller;

import cn.wmyskxz.entity.User;
import cn.wmyskxz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class PageController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listAll() {
        List<User> users = userService.listAll();
        System.out.println("返回数据个数:"+users.size());
        System.out.println(users);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 4);
        map.put("data", users);
        return map;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> add(@RequestBody User user) {
        int result = userService.insert(user);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    private Map<String, Object> deleteById(@PathVariable("id") int id) {
        System.out.println("是否请求删除过");
        int result = userService.deleteById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    private Map<String, Object> update(@RequestBody User user) {
        System.out.println("更新过了!");
        int result = userService.update(user);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping(value = "/findSpecificStudent")
    @ResponseBody
    public Map<String, Object> findSpecificStudent(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("sex") String sex,  int page, int limit) {
        int stuId=-1;
        if(id.length()!=0){
            stuId=Integer.parseInt(id);
        }
        if(name.length()==0){
            name="null";
        }
        if(phone.length()==0){
            phone="null";
        }
        if(sex.length()==0)
            sex="null";
        else if(sex.equals("1")){
            sex="男";
        }
        else{
            sex="女";
        }

        System.out.println("查找过！");
        System.out.println("id:"+id+"\nname:"+name+"\nsex:"+sex+"\nphone:"+phone);

        List<User> users = userService.getById(stuId,name,phone,sex);
        int count = users.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "");
        map.put("code", 0);
        map.put("count", count);
        map.put("data", users);
        System.out.println(map);
        return map;
    }
}
