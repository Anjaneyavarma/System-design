package LLD.FactoryPattern.ExampleOne;

public class ProductPhone implements Product{
    @Override
    public void printDescription() {
        System.out.println("This product is Iphone");
    }
}
