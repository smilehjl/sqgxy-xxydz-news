package sqgxy.xxydz.permission.annotation;

import java.lang.annotation.*;

/**
 * @author xmp
 * @date 2022-11-21 0:30
 * 权限自定义注解
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {

    int role() default 0;
}
