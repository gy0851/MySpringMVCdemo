package com.ggyy0851.convertors;


import org.springframework.core.convert.converter.Converter;

import java.awt.print.Book;

/**
 * @author GeYao
 * @create 2020-06-11 - 15:00
 */
public class Myconvertors implements Converter<String,Book> {

    @Override
    public Book convert(String source) {
        Book t = new Book();
        return t;
    }
}
