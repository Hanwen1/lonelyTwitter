package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hanwen1 on 1/17/17.
 */

public class Mood1 extends Mood {
    public Mood1(Date date, String message) throws TweetToLongException {
        super(date, message);
    }

    public Mood1(String message) throws TweetToLongException {
        super(message);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
