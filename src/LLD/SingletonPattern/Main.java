package LLD.SingletonPattern;

public class Main {

    public static void main(String[] args){
        DatabaseConnectionManager databaseConnectionManager = DatabaseConnectionManager.getInstance();
        databaseConnectionManager.showMessage();
    }
}
