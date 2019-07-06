package com.codepath.apps.restclienttemplate.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tweet implements Parcelable {
    // list of the attributes of a tweet
    public String body;
    public long uid;
    public User user;
    public String createdAt;
    public Entity entity;
    public boolean hasEntity;


    public Tweet (){};

    protected Tweet(Parcel in) {
        body = in.readString();
        uid = in.readLong();
        createdAt = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(body);
        dest.writeLong(uid);
        dest.writeString(createdAt);
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    public static final Creator<Tweet> CREATOR = new Creator<Tweet>() {
        @Override
        public Tweet createFromParcel(Parcel in) {
            return new Tweet(in);
        }

        @Override
        public Tweet[] newArray(int size) {
            return new Tweet[size];
        }
    };

    // deserialize the JSON
    public static Tweet fromJSON(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        // getting the data from the JSON
        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));

        JSONObject entityObject = jsonObject.getJSONObject("entities");
        if (entityObject.has("media")) {
            JSONArray mediaEndpoint = entityObject.getJSONArray("media");
            if (mediaEndpoint != null && mediaEndpoint.length()!= 0){
                tweet.entity = Entity.fromJSON(jsonObject.getJSONObject("entities"));
                tweet.hasEntity = true;
            }
        } else {

        }



        //tweet.entity = Entity.fromJSON()



        return tweet;

    }

}
