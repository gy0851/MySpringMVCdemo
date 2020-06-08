package com.ggyy0851.filter;

import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作用是将通过spring提供的hiddenhttpMethodfilter过滤的方法过滤回来，否则在tomcat7以上的版本中会报405错误
 * 虽然也可以通过其他方式解决，但这个方式最为根本
 * @author GeYao
 * @create 2020-06-04 - 18:20
 */
public class FilterForHiddenMethod extends HiddenHttpMethodFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String method = httpServletRequest.getMethod();
        if (method.equalsIgnoreCase("delete") || method.equalsIgnoreCase("put")) { method = "POST"; }
        httpServletRequest = new HttpMethodRequestWrapper(request, method);
        filterChain.doFilter(httpServletRequest, response);
    }
    private static class HttpMethodRequestWrapper extends HttpServletRequestWrapper {
        private final String method;
        public HttpMethodRequestWrapper(HttpServletRequest request, String method) {
            super(request);    this.method = method;
        }
        public String getMethod() { return this.method; }
    }
}
