package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hanwen1 on 1/17/17.
 */

public abstract class Mood extends Tweet {
    private Date date;

    public Mood(Date date, String message) throws TweetToLongException {
        super(date, message);
    }

    public Mood(String message) throws TweetToLongException {
        super(message);
    }
}
