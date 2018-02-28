package junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ozc on 2017/4/21.
 */
public class Demo3 {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        //反射出该类的方法
        Class aClass = Demo2.class;
        Method method = aClass.getMethod("add", String.class, int.class);

        //通过该方法得到注解上的具体信息
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        String username = annotation.username();
        int age = annotation.age();

        //将注解上的信息注入到方法上
        Object o = aClass.newInstance();
        method.invoke(o, username, age);

    }
}
