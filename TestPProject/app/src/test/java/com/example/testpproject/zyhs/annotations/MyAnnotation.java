package com.example.testpproject.zyhs.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@TestAnnotation( "456")
public @interface MyAnnotation {

    String value() default "123";

    String name() default "";

    int age() default 0;

    float[] grade() default {90f, 85f, 98};
}
