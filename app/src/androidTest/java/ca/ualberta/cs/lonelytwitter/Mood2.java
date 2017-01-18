package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hanwen1 on 1/17/17.
 */

public class Mood2 extends Mood {
    public Mood2(Date date, String message) throws TweetToLongException {
        super(date, message);
    }

    public Mood2(String message) throws TweetToLongException {
        super(message);
    }
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
