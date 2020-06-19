package com.ggyy0851.pojo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义异常
 * @author GeYao
 * @create 2020-06-17 - 15:07
 */
@ResponseStatus(reason = "用户名错误",value = HttpStatus.NOT_FOUND)
public class MyException extends RuntimeException{
}
