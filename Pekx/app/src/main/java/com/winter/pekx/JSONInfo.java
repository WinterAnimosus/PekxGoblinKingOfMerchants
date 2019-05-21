package com.winter.pekx;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class JSONInfo {
    private final String TAG = "JSONInfo";

    private Context context;

    public JSONInfo(Context current){
        this.context = current;
    }
    public String loadJSON(){
        InputStream is = null;
        String jsonString = "";
        try {
            is = context.getResources().openRawResource(R.raw.data);
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
             jsonString = writer.toString();
        } catch(UnsupportedEncodingException uEx) {
            Log.d(TAG, "loadJSON: ");
        } catch (IOException ioEx) {
            Log.d(TAG, "loadJSON: IO exception ");
        }
            finally {
            try {
                is.close();
            } catch (IOException ioEx) {
                Log.d(TAG, "loadJSON: IO exception ");
            }
        }


        return jsonString;
    }
    GameObject game = new GameObject();
    public String parseJSON(String jsonString, int save, int area, int scene){
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray savesArray = jsonObject.getJSONArray("saves");
            JSONArray areasArray = jsonObject.getJSONArray("scenesArea");
            JSONArray scenesArray = jsonObject.getJSONArray("scenesId");
            String jsonIds = "";
                //parsing for the save properties
                game.setCurrentAreaId(savesArray.getJSONObject(save).getInt("currentAreaId"));

                game.setCurrentSceneId(savesArray.getJSONObject(save).getInt("currentSceneId"));

                game.setCharacterName(savesArray.getJSONObject(save).getInt("characterName"));

                game.setSaveTimeDate(savesArray.getJSONObject(save).getInt("saveTimeDate"));
                //parsing for the scene properties
                game.setsceneTitle(areasArray.getJSONObject(area).scenesArray.getJSONObject(scene).getInt("sceneTitle"));

                game.setSceneImageId(scenesArray.getJSONObject(scene).getInt("sceneImageId"));

                game.setSceneText1(scenesArray.getJSONObject(scene).getInt("sceneText1"));

                game.setSceneText2(scenesArray.getJSONObject(scene).getInt("sceneText2"));

                game.setSceneText3(scenesArray.getJSONObject(scene).getInt("sceneText3"));

                game.setSceneChar1Id(scenesArray.getJSONObject(scene).getInt("sceneChar1Id"));

                game.setSceneChar2Id(scenesArray.getJSONObject(scene).getInt("sceneChar2Id"));

                game.setSceneOption1Txt(scenesArray.getJSONObject(scene).getInt("sceneOption1Txt"));

                game.setSceneOption1Area(scenesArray.getJSONObject(scene).getInt("sceneOption1Area"));

                game.setSceneOption1SceneId(scenesArray.getJSONObject(scene).getInt("sceneOption1SceneId"));

                game.setSceneOption2Txt(scenesArray.getJSONObject(scene).getInt("sceneOption2Txt"));

                game.setSceneOption2Area(scenesArray.getJSONObject(scene).getInt("sceneOption2Area"));

                game.setSceneOption2SceneId(scenesArray.getJSONObject(scene).getInt("sceneOption2SceneId"));

                game.setDefaultNextArea(scenesArray.getJSONObject(scene).getInt("defaultNextArea"));

                game.setDefaultNextScene(scenesArray.getJSONObject(scene).getInt("defaultNextScene"));

            return "\n"+jsonIds;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }
}
    // Variables for JSON objects
    //    SAVE VARIABLES
     class GameObject extends Object{
//      AreaId
        public Integer currentAreaId;

        public Integer getCurrentAreaId(){
           return currentAreaId;
        }
        public void  setCurrentAreaId (Integer currentAreaId ){
            this.currentAreaId = currentAreaId;
        }
//      SceneId
        public Integer currentSceneId;

        public Integer getCurrentSceneId(){
            return currentSceneId;
        }
        public void  setCurrentSceneId (Integer currentSceneId ){
            this.currentSceneId = currentSceneId;
        }
        // Character Name
        public Integer characterName;

        public Integer getCharacterName(){
            return characterName;
        }
        public void  setCharacterName (Integer characterName ){
            this.characterName = characterName;
        }
//        SaveTimeDate
        public Integer saveTimeDate;

        public Integer getSaveTimeDate(){
            return saveTimeDate;
        }
        public void  setSaveTimeDate (Integer saveTimeDate ){
            this.saveTimeDate = saveTimeDate;
        }
//        END SAVE VARIABLES
//        SCENE VARIABLES
//        SceneTitle
        public Integer sceneTitle;

        public Integer getsceneTitle(){
            return sceneTitle;
        }
        public void  setsceneTitle (Integer sceneTitle ){
            this.sceneTitle = sceneTitle;
        }
//        SceneImageId
        public Integer sceneImageId;

        public Integer getSceneImageId(){
            return sceneImageId;
        }
        public void  setSceneImageId (Integer SceneImageId ) {
            this.sceneImageId = sceneImageId;
        }
//        sceneText1
        public Integer sceneText1;

        public Integer getSceneText1(){
            return sceneText1;
        }
        public void  setSceneText1(Integer SceneText1 ) {
            this.sceneText1 = sceneText1;
        }
//        SceneText2
        public Integer sceneText2;

        public Integer getSceneText2(){
            return sceneText2;
        }
        public void  setSceneText2(Integer SceneText2 ) {
            this.sceneText2 = sceneText2;
        }
//        SceneText3
        public Integer sceneText3;

        public Integer getSceneText3(){
            return sceneText3;
        }
        public void  setSceneText3(Integer SceneText3 ) {
            this.sceneText3 = sceneText3;
        }
//        SceneCharId
        public Integer sceneChar1Id;

        public Integer getSceneChar1Id(){
            return sceneChar1Id;
        }
        public void  setSceneChar1Id(Integer SceneChar1Id ) {
            this.sceneChar1Id = sceneChar1Id;
        }
//        SceneChar2Id
        public Integer sceneChar2Id;

        public Integer getSceneChar2Id(){
            return sceneChar2Id;
        }
        public void  setSceneChar2Id(Integer SceneChar2Id ) {
            this.sceneChar2Id = sceneChar2Id;
        }
//        sceneOption1Txt
        public Integer sceneOption1Txt;

        public Integer getSceneOption1Txt(){
            return sceneOption1Txt;
        }
        public void  setSceneOption1Txt(Integer SceneOption1Txt ) {
            this.sceneOption1Txt = sceneOption1Txt;
        }
//        SceneOption1Area
        public Integer sceneOption1Area;

        public Integer getSceneOption1Area(){
            return sceneOption1Area;
        }
        public void  setSceneOption1Area(Integer SceneOption1Area ) {
            this.sceneOption1Area = sceneOption1Area;
        }
//        SceneOption1SceneId
        public Integer sceneOption1SceneId;

        public Integer getSceneOption1SceneId(){
            return sceneOption1Area;
        }
        public void  setSceneOption1SceneId(Integer SceneOption1SceneId ) {
            this.sceneOption1SceneId = sceneOption1SceneId;
        }
        //        sceneOption2Txt
        public Integer sceneOption2Txt;

        public Integer getSceneOption2Txt(){
            return sceneOption2Txt;
        }
        public void  setSceneOption2Txt(Integer SceneOption2Txt ) {
            this.sceneOption2Txt = sceneOption2Txt;
        }
        //        SceneOption2Area
        public Integer sceneOption2Area;

        public Integer getSceneOption2Area(){
            return sceneOption2Area;
        }
        public void  setSceneOption2Area(Integer SceneOption2Area ) {
            this.sceneOption2Area = sceneOption2Area;
        }
        //        SceneOption2SceneId
        public Integer sceneOption2SceneId;

        public Integer getSceneOption2SceneId(){
            return sceneOption2Area;
        }
        public void  setSceneOption2SceneId(Integer SceneOption2SceneId ) {
            this.sceneOption2SceneId = sceneOption2SceneId;
        }
//      DefaultNextArea
public Integer defaultNextArea;

        public Integer getDefaultNextArea(){
            return defaultNextArea;
        }
        public void  setDefaultNextArea(Integer DefaultNextArea ) {
            this.defaultNextArea = defaultNextArea;
        }
//      DefaultNextScene
public Integer defaultNextScene;

        public Integer getDefaultNextScene(){
            return defaultNextScene;
        }
        public void  setDefaultNextScene(Integer DefaultNextScene ) {
            this.defaultNextScene = defaultNextScene;
        }
//        END SCENE VARIABLES
    }


