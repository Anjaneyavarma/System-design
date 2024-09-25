package LLD.FactoryPattern.ExampleTwo;

public class Main {
    public static void main(String[] args){
        CreatorCircle creatorCicle = new CreatorCircle();
        Shape shape = creatorCicle.getShape();
        shape.printShape();

        CreatorRectangle creatorRectangle = new CreatorRectangle();
        Shape shape1 = creatorRectangle.getShape();
        shape1.printShape();

    }
}
