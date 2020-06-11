package com.ggyy0851.convertors;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GeYao
 * @create 2020-06-02 - 17:27
 */
public class SomethingToOther implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if(source == null){
            throw new RuntimeException("数据传入错误");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date(System.currentTimeMillis());
    }
}
