package LLD.StrategyPattern;

public class TransportContext {
    private TransportInterface transportInterface;

    public TransportContext(TransportInterface transportInterface){
        this.transportInterface = transportInterface;
    }
    public void setTransportInterface(TransportInterface transportInterface) {
        this.transportInterface = transportInterface;
    }

    public void performSearch(){
        transportInterface.modeOfTransport();
        transportInterface.priceOfTicket();
        transportInterface.timeTakenToReachDestination();
    }
}
