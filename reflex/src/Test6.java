import java.lang.reflect.Field;

public class Test6 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person p = new Person();
        p.setName("张三");
        setProperty(p,"name","张三");
    }
    //给任意对象的任意属性赋值
    //给obj的pName赋值为value
    static void setProperty(Object obj,String pName,Object value) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = obj.getClass();
        Field field = clazz.getDeclaredField(pName);
        field.set(obj,value);//默认调动setter方法
    }
}
