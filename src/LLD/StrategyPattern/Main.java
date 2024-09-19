package LLD.StrategyPattern;

public class Main {

    public static void main(String[] args){
        TransportContext transportContext = new TransportContext(new Bus());
        transportContext.performSearch();
        System.out.println("==============================================");
        transportContext.setTransportInterface(new Train());
        transportContext.performSearch();
    }



}
