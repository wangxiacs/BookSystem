package zhongfucheng.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ozc on 2017/4/25.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface permission {
    String value();
}
