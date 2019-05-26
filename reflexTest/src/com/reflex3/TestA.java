package com.reflex3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestA {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println("请输入类A的全名:");
        Scanner input = new Scanner(System.in);
        String className = input.next();
        Class clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor(String.class);
        Object a = constructor.newInstance("对象A");
        Method method = clazz.getMethod("showString", String.class);
        method.invoke(a,className);
    }
}