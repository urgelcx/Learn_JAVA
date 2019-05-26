package com.reflex1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Lcx.class;
        Object lcx = clazz.newInstance();
        System.out.println(lcx instanceof Lcx);
        Class clazz1 = Class.forName("com.reflex1.Lcx");
        Constructor constructors=clazz1.getConstructor(String.class,int.class);
        Object lcx1 = constructors.newInstance("lcx",18);
        System.out.println(lcx1 instanceof Lcx);
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

    void test(){
        System.out.println(this.name+this.age);
    }
}
