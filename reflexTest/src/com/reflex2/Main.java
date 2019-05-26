package com.reflex2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Lcx.class;
        Object lcx = clazz.newInstance();
        Method method = clazz.getMethod("test");
        method.invoke(lcx);
    }
}

class Lcx{
    private String name;
    private int age;

    public Lcx(String name,int age){
        this.name=name;
        this.age=age;
    }
    public Lcx(){}
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void test(){
        System.out.println("aaaaaaaaabbbbbbbbbbb");
    }
}
