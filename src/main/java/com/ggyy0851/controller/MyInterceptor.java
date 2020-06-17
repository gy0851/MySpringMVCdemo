package com.ggyy0851.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GeYao
 * @create 2020-06-15 - 13:53
 * 拦截器的实现
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("1111111111111111111111111111111111");
        System.out.println(handler.getClass());
        //只要此处返回true，之后的都会执行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("222222222222222222222222222222222222");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //只要本拦截器放行了，本拦截器的这个方法总会执行
        System.out.println("333333333333333333333333333333333333");
    }
}
