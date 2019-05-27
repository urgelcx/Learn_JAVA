import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Class classType=Tester.class;
//        Object tester=classType.newInstance();
//        Method addMethod=classType.getMethod("test",new
//                Class[]{int.class,Integer.class});
//        Object result=addMethod.invoke(tester,
//                new Object[]{new Integer(100),new Integer(200)});


    }
}

class Tester{
    public int test(int p1, Integer p2){
        System.out.println("1112111");
        return 1;
    }
}