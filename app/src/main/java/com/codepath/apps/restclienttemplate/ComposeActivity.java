package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import cz.msebera.android.httpclient.Header;

public class ComposeActivity extends AppCompatActivity {

    public static final String RESULT_TWEET_KEY = "result_tweet";

    Button btnCompose;
    EditText etNewTweet;
    TextView etCount;
    TwitterClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3498db")));

        etNewTweet = findViewById(R.id.etNewTweet);
        etCount = findViewById(R.id.etCount);

        btnCompose = findViewById(R.id.btnCompose);
        btnCompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                sendTweet();
            }

        });

        etNewTweet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = etNewTweet.length();
                String convert = String.valueOf(length);
                etCount.setText(convert + "/280");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    public void sendTweet(){
        client = TwitterApp.getTwitterClient(this);
        client.sendTweet(etNewTweet.getText().toString(), new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONObject responseJson = new JSONObject(new String(responseBody));
                    Tweet resultTweet = Tweet.fromJSON(responseJson);

                    Intent resultData = new Intent(ComposeActivity.this, TimelineActivity.class);
                    resultData.putExtra(RESULT_TWEET_KEY, Parcels.wrap(resultTweet));
                    startActivityForResult(resultData, statusCode);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });
    }







}

