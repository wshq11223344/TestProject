package com.example.testpproject.designmode.factorymode;

import org.junit.Test;

public class FactoryPatternDemo {


    @Test
    public void test() {


        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("Circle");
        if (circle != null) {

            circle.draw();
        }

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        if (rectangle != null) {

            rectangle.draw();
        }

        Shape square = shapeFactory.getShape("SQUARE");
        if (square != null) {

            square.draw();
        }
    }
}
