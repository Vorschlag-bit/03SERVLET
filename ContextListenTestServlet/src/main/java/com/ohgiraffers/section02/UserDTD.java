package com.ohgiraffers.section02;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

/* 설명. HttpSessionBindingListen는 해당 클래스에 리스너를 추가해야 한다. */
public class UserDTD implements HttpSessionBindingListener {
    private String Name;
    private int age;

    public UserDTD() {}

    public UserDTD(int age, String name) {
        this.age = age;
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTD{" +
                "age=" + age +
                ", Name='" + Name + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("UserDTD 담김!");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("UserDTD가 제거됌");
    }
}
