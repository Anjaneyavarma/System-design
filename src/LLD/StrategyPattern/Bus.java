package LLD.StrategyPattern;

public class Bus implements TransportInterface{
    @Override
    public void modeOfTransport() {
        System.out.println("Mode of transport is bus");
    }

    @Override
    public void priceOfTicket() {
        System.out.println("Price of Bus ticket is 1300 Rupees");
    }

    @Override
    public void timeTakenToReachDestination() {
        System.out.println("Time taken to reach destination via bus is 10 hours");
    }
}
