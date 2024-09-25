package LLD.FactoryPattern.ExampleOne;

public class Main {
    public static void main(String[] args){
        Creator creatorIphone = new CreatorIphone();
        Product productIphone = creatorIphone.factoryMethod();
        productIphone.printDescription();

    }
}
