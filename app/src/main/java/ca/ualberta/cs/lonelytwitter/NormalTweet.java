/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */



//one line comment

/*multiple line coment


 *asdfasdf

 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hanwen1 on 1/17/17.
 */
public class NormalTweet extends Tweet {
    /**
     * Instantiates a new Normal tweet.
     *
     * @param date    the date of tweet
     * @param message the message
     * @throws TweetToLongException the tweet to long exception
     */
    public NormalTweet(Date date, String message) throws TweetToLongException {
        super(date, message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     * @throws TweetToLongException the tweet to long exception
     */
    public NormalTweet(String message) throws TweetToLongException {
        super(message);
    }

    public Boolean isImportant(){
        return Boolean.FALSE;
    }
}
