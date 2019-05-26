package com.reflex4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Class<Person> clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class,int.class);
        Object person = constructor.newInstance("lcx", 18);

        System.out.println("第一次使用有参构造函数：");
        printInformation(person);
        System.out.println();

        Method setNameMethod = clazz.getMethod("setName", String.class);
        setNameMethod.invoke(person, "Urge");

        System.out.println("用setName方法修改name：");
        printInformation(person);
        System.out.println();

        Field field = clazz.getDeclaredField("age");
        field.setAccessible(true);
        field.set(person, 19);

        System.out.println("不用set方法直接修改age：");
        printInformation(person);
    }
    private static void printInformation(Object object) throws IllegalAccessException {
        Field[] field1 = object.getClass().getDeclaredFields();
        for (int i = 0 ;i<field1.length;i++){
            field1[i].setAccessible(true);
            System.out.println(field1[i].getName()+":"+field1[i].get(object));
        }
    }
}
