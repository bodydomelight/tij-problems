package annotations.database;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLDate {

    String name() default "";

    Constraints constraints() default @Constraints;
}
