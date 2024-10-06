package LLD.AbstarctFactory;

public class NorthAmericaSpecification implements CarSpecification{
    @Override
    public void createSpecification() {
        System.out.println("Left Side driving");
    }
}
