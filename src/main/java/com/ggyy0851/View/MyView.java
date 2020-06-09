package com.ggyy0851.View;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author GeYao
 * @create 2020-06-09 - 14:32
 */
public class MyView implements View{

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<String> href = (List<String>) map.get("href");
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        httpServletResponse.getWriter().write("这是自定义页面<h3>这是自定义页面</h3>");
        for (String s:href){
            httpServletResponse.getWriter().write("<a href='"+s+"'>链接</a><br/>");
        }
    }
}
