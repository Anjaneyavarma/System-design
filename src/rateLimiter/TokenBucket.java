package rateLimiter;

import java.time.Instant;

public class TokenBucket {

    private int max_bucket_size = 3;
    private int current_bucket_size;
    private int refill_rate = 1;
    Instant nextRefillTimeStamp = Instant.now();//set the timestamp

    public boolean allowRequests(){
        refillBucket();
        if(current_bucket_size > 0){
            current_bucket_size--;
            return true;
        }
        return false;
    }

    public void refillBucket(){
        Instant now = Instant.now(); // current time stamp
        if(now.isAfter(nextRefillTimeStamp)) {
            System.out.println("setting the token bucket");
            current_bucket_size = max_bucket_size;
            nextRefillTimeStamp = now.plusSeconds(refill_rate); // increase it by 1 second
        }else {
            current_bucket_size = Math.min(current_bucket_size, max_bucket_size);
        }
    }

    public static void main(String[] args) {
        TokenBucket tokenBucket = new TokenBucket();
        System.out.println(tokenBucket.allowRequests());//true
        System.out.println(tokenBucket.allowRequests());//true
        System.out.println(tokenBucket.allowRequests());//true
        System.out.println(tokenBucket.allowRequests());//false

    }

}
