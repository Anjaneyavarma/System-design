package LLD.AbstarctFactory;

public class Main {
    public static void main(String[] args){
        CarFactory carFactory = new NorthAmericaCar();
        Car northAmericaCar = carFactory.createCar();
        CarSpecification northAmericaSpecification = carFactory.createSpecification();

        northAmericaCar.createCar();
        northAmericaSpecification.createSpecification();

        CarFactory carFactory1 = new EuropeCar();
        Car car = carFactory1.createCar();
        CarSpecification carSpecification = carFactory1.createSpecification();

        car.createCar();
        carSpecification.createSpecification();
    }
}
