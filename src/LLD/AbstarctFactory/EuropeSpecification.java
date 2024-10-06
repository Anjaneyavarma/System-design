package LLD.AbstarctFactory;

public class EuropeSpecification implements CarSpecification{
    @Override
    public void createSpecification() {
        System.out.println("Right side driving");
    }
}
