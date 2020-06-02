package com.ggyy0851.controller;

import java.io.Serializable;

/**
 * @author GeYao
 * @create 2020-06-02 - 17:33
 */
public class User implements Serializable {
    private String name;
    private String age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
