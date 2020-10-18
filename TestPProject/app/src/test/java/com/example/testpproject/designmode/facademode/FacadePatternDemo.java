package com.example.testpproject.designmode.facademode;

public class FacadePatternDemo {

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();

        Math.random();
        System.out.println((int) (Math.random() * 5));
    }
}
