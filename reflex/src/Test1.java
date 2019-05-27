/**
 * Class对象：一个类会有一个与之对应class类的实例，在类加载的时候
 *           诞生的对象，代表的是该类的信息
 * 通过对象
 * 通过.class
 * 通过Class.forname()
 * @author LCX
 * **/

class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        //clazz对象，创建Student对象之前，clazz对象就存在--Student类加载
        //通过该类的对象得到clazz实例
        Class clazz1 = new Student().getClass();
        Class clazz2 = new Student().getClass();
        //true:每个类都有一个对应的clazz对象
        System.out.println(clazz1 == clazz2);
        //通过.class关键字得到clazz对象
        Class clazz3 = Student.class;
        //通过类的全路径得到clazz对象
        Class clazz4 = Class.forName("Main");

        System.out.println(clazz1==clazz3);
        System.out.println(clazz1==clazz4);
    }
}

class Student extends Person{
    String name;
    public void test(){

    }
}
