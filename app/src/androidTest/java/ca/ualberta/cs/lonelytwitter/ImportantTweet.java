package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hanwen1 on 1/17/17.
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(Date date, String message) throws TweetToLongException {
        super(date, message);
    }

    public ImportantTweet(String message) throws TweetToLongException {
        super(message);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " !!!!";
    }
}