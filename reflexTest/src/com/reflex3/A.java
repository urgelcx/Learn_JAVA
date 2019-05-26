package com.reflex3;

class A {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public A() {

    }
    public A(String name) {
        this.name=name;
    }
    public void showString(String str) {
        System.out.println("类A:"+str);
    }
}
