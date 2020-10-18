package com.example.testpproject.designmode.factorymode;

public class ShapeFactory {

    public Shape getShape(String shapeType) {

        if (shapeType == null) {

            return null;
        }

        Shape shape = null;

        switch (shapeType) {
            case "Circle":
                shape = new Circle();
                break;
            case "RECTANGLE":
                shape = new Rectangle();
                break;
            case "SQUARE":
                shape = new Square();
                break;
            default:
                break;
        }

        return shape;


    }
}
