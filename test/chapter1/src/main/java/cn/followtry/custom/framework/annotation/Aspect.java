package cn.followtry.custom.framework.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by followtry on 2017/4/14.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Aspect {

	Class<? extends Annotation> value();

}
