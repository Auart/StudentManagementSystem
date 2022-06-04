package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  //设置注解生命周期的运行时一直存活
@Target(ElementType.METHOD)
public @interface After {
}
