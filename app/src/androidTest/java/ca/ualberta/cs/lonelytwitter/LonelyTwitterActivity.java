package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);


		//Tweet tweet2 = new Tweet(new Date(),"My Second Tweet");
        try {
			Tweet tweet = new NormalTweet("First tweet");
			tweet.setMessage("asdfasdg");
			ImportantTweet importantTweet = new ImportantTweet("important");
			importantTweet.getDate();
			NormalTweet normalTweet = new NormalTweet("in normal");

			ArrayList<Tweet> arrayList = new ArrayList<Tweet>();
			arrayList.add(tweet);
			arrayList.add((Tweet) importantTweet);
			arrayList.add(normalTweet);

		}catch (TweetToLongException e) {
			e.printStackTrace();
		}



		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				try {
					Tweet tweet = new NormalTweet(text);
					tweetList.add(tweet);

					adapter.notifyDataSetChanged();
//				saveInFile(text, new Date(System.currentTimeMillis()));
//				finish();
					saveInFile();
				}catch(TweetToLongException e){

				}
			}
		});

        clearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                //try {

                tweetList.clear();
                adapter.notifyDataSetChanged();
                //}catch(TweetToLongException e){

               // }
            }
        });

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			//String line = in.readLine();

            Gson gson = new Gson();

			//
			//2017-01-24 18:19
//			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
//            tweetList = gson.fromJson(in,listType);
            tweetList = gson.fromJson(in, new TypeToken<ArrayList<NormalTweet>>(){}.getType());

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();

		} catch (IOException e) {
			throw new RuntimeException();
		}
		//return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
//			fos.write(new String(date.toString() + " | " + text)
//					.getBytes());
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO: Handle the Exception properly later
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}