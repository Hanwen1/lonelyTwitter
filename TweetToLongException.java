package ca.ualberta.cs.lonelytwitter;



/**
 * Created by hanwen1 on 1/17/17.
 */

public class TweetToLongException extends Exception {
    public TweetToLongException() {
    }

    public TweetToLongException(String detailMessage) {
        super(detailMessage);
    }
}
