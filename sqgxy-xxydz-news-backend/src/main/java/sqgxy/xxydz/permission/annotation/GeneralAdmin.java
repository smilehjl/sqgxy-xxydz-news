package sqgxy.xxydz.permission.annotation;

import java.lang.annotation.*;

/**
 * @author xmp
 * @date 2022-11-21 22:28
 * 普通管理员权限
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Permission

public @interface GeneralAdmin {
    int role() default 0;
}
