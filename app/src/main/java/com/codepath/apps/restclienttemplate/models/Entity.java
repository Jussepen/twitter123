package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Entity {

    public String mediaURL;

    public static Entity fromJSON(JSONObject jsonObject) throws JSONException {
        Entity entity = new Entity();
        entity.mediaURL = jsonObject.getJSONArray("media").getJSONObject(0).getString("media_url_https");

        return entity;
    }


}



