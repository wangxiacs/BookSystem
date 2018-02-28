package junit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ozc on 2017/4/19.
 */
public abstract class function {

    public static void main(String[] args) {


        List list = new ArrayList();
        List<String> list2 = list;

    }


    //使用通配符
    public static void test(List<?> list) {

    }

    //使用泛型方法
    public <T> void  test2(List<T> t) {

    }

}
