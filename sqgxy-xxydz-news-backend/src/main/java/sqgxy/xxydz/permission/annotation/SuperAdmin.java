package sqgxy.xxydz.permission.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author xmp
 * @date 2022-11-21 22:16
 * 超级管理员
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Permission
public @interface SuperAdmin {

    @AliasFor(annotation = Permission.class)
    int role() default 1;
}
