import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test4 {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String str = "sfasfsdafsafafsadfsa";
        String subString = str.substring(3,7);
        System.out.println(subString);
        getSub(str,3,7,String.class);

    }
    static void getSub(String str, int begin, int end, Class<String> clazz) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method[] methods = clazz.getMethods();
        Object obj = null;
        for (Method m:methods){
            if (m.getName().equals("substring")){
                if (m.getParameterCount()==2){
                    obj = m.invoke(str,begin,end);
                }
            }
        }
        System.out.println(obj);

        Method m = clazz.getDeclaredMethod("substring",int.class,int.class);
        obj = m.invoke(str,begin,end);
        System.out.println(obj);
    }



}
