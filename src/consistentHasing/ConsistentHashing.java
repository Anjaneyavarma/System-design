package consistentHasing;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ConsistentHashing {

    private Map<BigInteger, String> hashRing = new HashMap<>();
    private int server_replicas = 3;
    private List<BigInteger> sortedKeys = new ArrayList<>();

    BigInteger getHash(String input) throws NoSuchAlgorithmException, NumberFormatException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
        BigInteger number = new BigInteger(1, messageDigest);
        return number;
    }

    void add_server(String serverName) throws NoSuchAlgorithmException{
        for(int i=0;i<server_replicas;i++){
            String server_node = serverName+"_"+i;
            BigInteger hash_key = getHash(server_node);
            hashRing.put(hash_key, server_node);
            sortedKeys.add(hash_key);
        }
        Collections.sort(sortedKeys);
    }

    void remove_server(String serverName) throws NoSuchAlgorithmException{
        for(int i=0;i<server_replicas;i++){
            String server_node = serverName+"_"+i;
            BigInteger hash_key = getHash(server_node);
            hashRing.remove(hash_key);
            sortedKeys.remove(hash_key);
        }
        Collections.sort(sortedKeys);
    }

    String getNode(String key) throws NoSuchAlgorithmException{
        BigInteger hashKey = getHash(key);
        for(BigInteger k: sortedKeys){
            if(hashKey.compareTo(k)<=0){
                return hashRing.get(k);
            }
        }
        return "null";
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        ConsistentHashing ch = new ConsistentHashing();
        ch.add_server("Node1");
        ch.add_server("Node2");
        ch.add_server("Node3");
        System.out.println("server === "+ch.getNode("first_key"));
        System.out.println("server === "+ch.getNode("Second_key"));
        System.out.println("server === "+ch.getNode("third_key"));
        System.out.println("Removing Node server 3");
        ch.remove_server("Node3");
        System.out.println("server === "+ch.getNode("first_key"));
        System.out.println("server === "+ch.getNode("Second_key"));
        System.out.println("server === "+ch.getNode("third_key"));
    }
}
