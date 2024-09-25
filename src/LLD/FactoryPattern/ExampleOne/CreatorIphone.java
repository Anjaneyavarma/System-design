package LLD.FactoryPattern.ExampleOne;

public class CreatorIphone implements Creator{
    @Override
    public Product factoryMethod() {
        return new ProductPhone();
    }
}
