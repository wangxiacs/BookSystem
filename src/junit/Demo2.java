package junit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ozc on 2017/4/20.
 */

public class Demo2 {


    @MyAnnotation()
    public void add(String username, int age) {

        System.out.println(username + age);
    }



}
