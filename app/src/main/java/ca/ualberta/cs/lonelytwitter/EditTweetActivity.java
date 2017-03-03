package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        textView = (TextView)findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        String tweetString = extras.getString("PassingTweet");
        textView.setText(tweetString);
    }
}
