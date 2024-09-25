package LLD.FactoryPattern.ExampleOne;

public class CreatorLaptop implements Creator{
    @Override
    public Product factoryMethod() {
        return new ProductLaptop();
    }
}
