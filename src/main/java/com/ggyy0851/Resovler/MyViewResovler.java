package com.ggyy0851.Resovler;

import com.ggyy0851.View.MyView;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author GeYao
 * @create 2020-06-09 - 13:54
 */
public class MyViewResovler implements ViewResolver, Ordered {
    private Integer order;
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        //实现视图解析器中的方法
        if(s.startsWith("gyview:")){
            return new MyView();
        }
        return null;
    }

    @Override
    public int getOrder() {
        return order;
    }
    //此项属性用于排序，将本视图的解析顺序排在InternalResourceView默认解析类之前，否则会被InternalResourceView先解析，导致自定义视图失效
    public void setOrder(Integer order) {
        this.order = order;
    }
}
