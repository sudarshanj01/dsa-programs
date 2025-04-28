package l_javaPatterns;

interface Shape {
    void draw();
}

public class FactoryPattern {
    public Shape getShape(String shapType) {
        if (shapType == null) return null;

        if (shapType.equals("circle")) {
            return new Circle();
        } else if (shapType.equals("rectangle")) {
            return new Rectangle();
        } else return null;

    }

    public static void main(String[] args) {
        FactoryPattern shapeFactory = new FactoryPattern();

        Shape circle = shapeFactory.getShape("circle");
        circle.draw();

        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("drawing rectangle");
    }
}
