package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by hanwen1 on 2/14/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");

        tweets.add(tweet);
        Tweet retrunedTweet = tweets.getTweet(0);

        assertEquals(retrunedTweet.getMessage(), tweet.getMessage());
        assertEquals(retrunedTweet.getDate(), tweet.getDate());


    }



    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last tweet");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));


    }

    public void testStrings(){
        assertEquals("'test' should be 'test'", "test", "test");
        assertTrue("'test' should start with 't'", "test".startsWith("t"));
    }

    
    public void testGetTweets(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");
        tweets.add(tweet);
        for(int i=0;i<tweets.getCount();i++) {
            assertEquals(tweets.getTweet(i), tweets.gettweets().get(i));
        }
    }
    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");
        tweets.add(tweet);
        assertEquals(true,tweets.hasTweet(tweet));
    }

    public void testgetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");
        tweets.add(tweet);
        assertEquals(1,tweets.getCount());
    }
}
