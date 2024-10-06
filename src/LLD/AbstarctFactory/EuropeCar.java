package LLD.AbstarctFactory;

public class EuropeCar implements CarFactory{
    @Override
    public Car createCar() {
        return new Sedan();
    }

    @Override
    public CarSpecification createSpecification() {
        return new EuropeSpecification();
    }
}
