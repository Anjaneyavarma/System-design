package LLD.AbstarctFactory;

public class Sedan implements Car{

    @Override
    public void createCar() {
        System.out.println("Creating car sedan");
    }
}
