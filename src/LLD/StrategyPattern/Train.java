package LLD.StrategyPattern;

public class Train implements TransportInterface{
    @Override
    public void modeOfTransport() {
        System.out.println("Mode of transport is train");
    }

    @Override
    public void priceOfTicket() {
        System.out.println("Price of Train ticket is 300 Rupees");
    }

    @Override
    public void timeTakenToReachDestination() {
        System.out.println("Time taken to reach destination via train is 12 hours");
    }
}
