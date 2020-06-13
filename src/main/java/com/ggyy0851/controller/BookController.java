package com.ggyy0851.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author GeYao
 * @create 2020-06-04 - 17:09
 */
@Controller
public class BookController {
    @RequestMapping(value="/book",method = RequestMethod.POST)
    public String addBook(@RequestParam(value="name",required = false) String name){
        System.out.println("添加了图书:");
        return "success";
    }
    @RequestMapping(value="/book/{id}",method = RequestMethod.GET)
    public String getBook(@PathVariable("id") int id){
        System.out.println("获得了图书:"+id);
        return "success";
    }
    @RequestMapping(value="/book/{id}",method = RequestMethod.DELETE)
    public String delBook(@PathVariable("id") @Validated int id, BindingResult result){
        if(result.hasErrors()){
            return "success";
        }
        System.out.println("删除了图书:"+id);
        return "success";
    }
    @RequestMapping(value="/book/{id}",method = RequestMethod.PUT)
    public String upBook(@PathVariable("id") int id){
        System.out.println("更新了图书:"+id);
        return "success";
    }
}
