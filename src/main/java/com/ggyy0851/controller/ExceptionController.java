package com.ggyy0851.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author GeYao
 * @create 2020-06-17 - 14:07
 */
@Controller
public class ExceptionController {
    @ExceptionHandler(value={Exception.class})
    public String MyExceptionHandler2(){
        System.out.println("进入了错误页面2");
        return "myerror";
    }
}
