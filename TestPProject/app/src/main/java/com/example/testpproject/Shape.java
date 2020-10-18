package com.example.testpproject;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Shape {

    public static final int RECTANGLE = 0;
    public static final int TRIANGLE = 1;
    public static final int SQUARE = 2;
    public static final int CIRCLE = 3;


    @IntDef(flag = true, value = {RECTANGLE, TRIANGLE})
    @Retention(value = RetentionPolicy.SOURCE)
    @Target(value = {ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public @interface Test {

    }


    private @Test
    int value = RECTANGLE;


    public void setShape(@Test int value) {
        this.value = value;
    }


    @Test
    public int getShape() {
        return this.value;
    }


    public void test() {

        Shape shapes = new Shape();
        shapes.setShape(RECTANGLE);
        shapes.setShape(RECTANGLE);
    }




}
