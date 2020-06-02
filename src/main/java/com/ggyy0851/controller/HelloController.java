package com.ggyy0851.controller;

import com.ggyy0851.pojo.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制器类
 * @author GeYao
 * @create 2020-06-02 - 13:42
 */
@Controller
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello String MVC");
        return "success";
    }
    @RequestMapping("/save")
    /**
     * 这里自组装传入的类比如account，必须有相应的get/set方法，否则会报错提示组装失败
     * 如果有必要，可以直接在方法参数中加入HttpServletRequest和HttpServletResponse来直接获取原生servlet的相应api
     * 默认是不需要写的
     */
    public String save(Account account, HttpServletRequest request, HttpServletResponse response,@RequestParam(name = "myname") String name){
        System.out.println("进入了save方法");
        System.out.println(account.toString());
        System.out.println(request+":"+response);
        return "success";
    }
}
