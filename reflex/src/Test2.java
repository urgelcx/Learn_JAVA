import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Student.class;

        //通过clazz来创建Person对象,构造函数Constructor
        Constructor[] c = clazz.getConstructors();

        //通过clazz来找到name属性
        Field[] fields = clazz.getDeclaredFields();

        //通过clazz来找到test方法，并执行
        Method[] methods = clazz.getDeclaredMethods();

        //创建clazz信息所在类的对象：newInstance():根据类的信息创建该类的对象
        Object obj = clazz.newInstance();
        fields[0].set(obj,"学生");

        Constructor cons = clazz.getConstructor(String.class);
        Object obj2 = cons.newInstance("张三");

        //调用obj的方法
        Object obj3 = methods[0].invoke(obj);
        System.out.println(obj3);
    }
}
class Person{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void test(){
        System.out.println("test");
    }
    public Person(){
        System.out.println("无参构造");
    }
    public Person(String name){
        this.name = name;
        System.out.println("有参构造");
    }
}
