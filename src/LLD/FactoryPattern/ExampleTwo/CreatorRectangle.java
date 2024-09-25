package LLD.FactoryPattern.ExampleTwo;

public class CreatorRectangle {
    public Shape getShape(){
        return new Rectangle();
    }
}
