package com.winter.pekx;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONInfo {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "../res/raw/data.json";

    // constructor
    public JSONInfo() {}

    public JSONObject getJSONFromUrl(String url) {

        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSONInfo", "Error parsing data " + e.toString());
        }

        // return JSON String
        return jObj;

    }
    //    Variables for JSON objects:
    public class JSONobjects extends Object{
        public String saves (String saves){
            return saves;
        }
        public Integer currentAreaId (Integer currentAreaId ){
           return currentAreaId;
        }
        public Integer currentSceneId (Integer currentSceneId ){
            return currentSceneId;
        }
        public String characterName (String characterName ){
            return characterName;
        }
        public String saveTimeDate (String saveTimeDate ){
            return saveTimeDate;
        }
        public String scenesArea (String scenesArea ){
            return scenesArea;
        }
        public String scenesId (String scenesId ){
            return scenesId;
        }
        public String sceneTitle (String sceneTitle ){
            return sceneTitle;
        }
        public String sceneText1 (String sceneText1 ){
            return sceneText1;
        }
        public String sceneText2 (String sceneText2 ){
            return sceneText2;
        }
        public String sceneText3 (String sceneText3 ){
            return sceneText3;
        }
        public String sceneImageId (String sceneImageId ){
            return sceneImageId;
        }
        public String sceneChar1Id (String sceneChar1Id ){
            return sceneChar1Id;
        }
        public String sceneChar2Id (String sceneChar2Id ){
            return sceneChar2Id;
        }
        public String sceneOption1Txt (String sceneOption1Txt ){
            return sceneOption1Txt;
        }
        public Integer sceneOption1Area (Integer sceneOption1Area ){
            return sceneOption1Area;
        }
        public Integer sceneOption1SceneId (Integer sceneOption1SceneId ){
            return sceneOption1SceneId;
        }
        public String sceneOption2Txt (String sceneOption2Txt ){
            return sceneOption2Txt;
        }
        public String sceneOption2Area (String sceneOption2Area ){
            return sceneOption2Area;
        }
        public String sceneOption2SceneId (String sceneOption2SceneId ){
            return sceneOption2SceneId;
        }
        public Integer defaultNextArea (Integer defaultNextArea ){
            return defaultNextArea;
        }
        public Integer defaultNextScene (Integer defaultNextScene ){
            return defaultNextScene;
        }
    }
}

