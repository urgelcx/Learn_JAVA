import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test5 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<Integer> list = new ArrayList<Integer>();
        list.add(11);
        list.add(42);
//        list.add("abc");
//        list.add(new Person());
        Method  m= list.getClass().getDeclaredMethod("add", Object.class);
        m.invoke(list,"abc");
        m.invoke(list,new Person());
    }
}
