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
import java.lang.reflect.Array;

public class JSONInfo {
    private final String TAG = "JSONInfo";

    private Context context;

    public JSONInfo(Context current){
        this.context = current;
    }
    public String loadJSON(int save, String doing){
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

        parseJSON(jsonString,save,doing);
        return jsonString;
    }
    GameObject game = new GameObject();
    public String parseJSON(String jsonString, int save, String doing){
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray savesArray = jsonObject.getJSONArray("saves");
            String jsonIds = "";
            if (doing.equals("load")) {
                //parsing for the save properties
                game.setCurrentAreaId(savesArray.getJSONObject(save).getString("currentAreaId"));
                game.setCurrentSceneId(savesArray.getJSONObject(save).getString("currentSceneId"));
                game.setCharacterName(savesArray.getJSONObject(save).getString("characterName"));
                game.setSaveTimeDate(savesArray.getJSONObject(save).getString("saveTimeDate"));
            } else if (doing.equals("new")) {
                savesArray.getJSONObject(save).put("currentAreaId","0");
                savesArray.getJSONObject(save).put("currentSceneId","0");
                savesArray.getJSONObject(save).put("characterName","");
                savesArray.getJSONObject(save).put("saveTimeDate","0");

                game.setCurrentAreaId(savesArray.getJSONObject(save).getString("currentAreaId"));
                game.setCurrentSceneId(savesArray.getJSONObject(save).getString("currentSceneId"));
                game.setCharacterName(savesArray.getJSONObject(save).getString("characterName"));
                game.setSaveTimeDate(savesArray.getJSONObject(save).getString("saveTimeDate"));
            }

            //parsing for the scene properties

            String areaScene[] = getVariables("areascene");

            if (doing.equals("save")) {
                savesArray.getJSONObject(save).put("currentAreaId",Integer.parseInt(areaScene[0]));
                savesArray.getJSONObject(save).put("currentSceneId",Integer.parseInt(areaScene[1]));
                savesArray.getJSONObject(save).put("saveTimeDate",Long.toString(System.currentTimeMillis()));

                game.setCurrentAreaId(savesArray.getJSONObject(save).getString("currentAreaId"));
                game.setCurrentSceneId(savesArray.getJSONObject(save).getString("currentSceneId"));
            }

//            if (doing.equals("next")) {
//                JSONArray areasArray = jsonObject.getJSONArray("scenesArea");
//                JSONArray scenesArray = areasArray.getJSONArray(Integer.parseInt(areaScene[1]));
//
//                game.setsceneTitle(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneTitle"));
//                game.setSceneImageId(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneImageId"));
//                game.setSceneText1(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneText1"));
//                game.setSceneText2(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneText2"));
//                game.setSceneText3(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneText3"));
//                game.setSceneChar1Id(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneChar1Id"));
//                game.setSceneChar2Id(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneChar2Id"));
//                game.setSceneOption1Txt(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneOption1Txt"));
//                game.setSceneOption1Area(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneOption1Area"));
//                game.setSceneOption1SceneId(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneOption1SceneId"));
//                game.setSceneOption2Txt(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneOption2Txt"));
//                game.setSceneOption2Area(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneOption2Area"));
//                game.setSceneOption2SceneId(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("sceneOption2SceneId"));
//                game.setDefaultNextArea(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("defaultNextArea"));
//                game.setDefaultNextScene(scenesArray.getJSONObject(Integer.parseInt(areaScene[2])).getString("defaultNextScene"));
//            } else {
                JSONArray areasArray = jsonObject.getJSONArray("scenesArea");
                JSONArray scenesArray = areasArray.getJSONArray(Integer.parseInt(areaScene[0]));

                game.setsceneTitle(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneTitle"));
                game.setSceneImageId(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneImageId"));
                game.setSceneText1(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneText1"));
                game.setSceneText2(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneText2"));
                game.setSceneText3(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneText3"));
                game.setSceneChar1Id(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneChar1Id"));
                game.setSceneChar2Id(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneChar2Id"));
                game.setSceneOption1Txt(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneOption1Txt"));
                game.setSceneOption1Area(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneOption1Area"));
                game.setSceneOption1SceneId(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneOption1SceneId"));
                game.setSceneOption2Txt(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneOption2Txt"));
                game.setSceneOption2Area(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneOption2Area"));
                game.setSceneOption2SceneId(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("sceneOption2SceneId"));
                game.setDefaultNextArea(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("defaultNextArea"));
                game.setDefaultNextScene(scenesArray.getJSONObject(Integer.parseInt(areaScene[1])).getString("defaultNextScene"));
//            }

            return "\n"+jsonIds;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }
    public String[] getVariables(String variableCalled)
    {

        if (variableCalled.equals("areaScene")) {
            String returnedVariables[] = new String[4];
            returnedVariables[0] = game.getCurrentAreaId();
            returnedVariables[1] = game.getCurrentSceneId();
            returnedVariables[2] = game.getDefaultNextArea();
            returnedVariables[3] = game.getDefaultNextScene();
            return returnedVariables;
        } else {
            String returnedVariables[] = new String[19];
            returnedVariables[0] = game.getCurrentAreaId();
            returnedVariables[1] = game.getCurrentSceneId();
            returnedVariables[2] = game.getCharacterName();
            returnedVariables[3] = game.getSaveTimeDate();
            returnedVariables[4] = game.getsceneTitle();
            returnedVariables[5] = game.getSceneImageId();
            returnedVariables[6] = game.getSceneText1();
            returnedVariables[7] = game.getSceneText2();
            returnedVariables[8] = game.getSceneText3();
            returnedVariables[9] = game.getSceneChar1Id();
            returnedVariables[10] = game.getSceneChar2Id();
            returnedVariables[11] = game.getSceneOption1Txt();
            returnedVariables[12] = game.getSceneOption1Area();
            returnedVariables[13] = game.getSceneOption1SceneId();
            returnedVariables[14] = game.getSceneOption2Txt();
            returnedVariables[15] = game.getSceneOption2Area();
            returnedVariables[16] = game.getSceneOption2SceneId();
            returnedVariables[17] = game.getDefaultNextArea();
            returnedVariables[18] = game.getDefaultNextScene();
            return returnedVariables;
        }
    }
}
    // Variables for JSON objects
    //    SAVE VARIABLES
     class GameObject extends Object{
//      AreaId
        public String currentAreaId;

        public String getCurrentAreaId(){
           return currentAreaId;
        }
        public void  setCurrentAreaId (String currentAreaId ){
            this.currentAreaId = currentAreaId;
        }
//      SceneId
        public String currentSceneId;

        public String getCurrentSceneId(){
            return currentSceneId;
        }
        public void  setCurrentSceneId (String currentSceneId ){
            this.currentSceneId = currentSceneId;
        }
        // Character Name
        public String characterName;

        public String getCharacterName(){
            return characterName;
        }
        public void  setCharacterName (String characterName ){
            this.characterName = characterName;
        }
//        SaveTimeDate
        public String saveTimeDate;

        public String getSaveTimeDate(){
            return saveTimeDate;
        }
        public void  setSaveTimeDate (String saveTimeDate ){
            this.saveTimeDate = saveTimeDate;
        }
//        END SAVE VARIABLES
//        SCENE VARIABLES
//        SceneTitle
        public String sceneTitle;

        public String getsceneTitle(){
            return sceneTitle;
        }
        public void  setsceneTitle (String sceneTitle ){
            this.sceneTitle = sceneTitle;
        }
//        SceneImageId
        public String sceneImageId;

        public String getSceneImageId(){
            return sceneImageId;
        }
        public void  setSceneImageId (String SceneImageId ) {
            this.sceneImageId = sceneImageId;
        }
//        sceneText1
        public String sceneText1;

        public String getSceneText1(){
            return sceneText1;
        }
        public void  setSceneText1(String SceneText1 ) {
            this.sceneText1 = sceneText1;
        }
//        SceneText2
        public String sceneText2;

        public String getSceneText2(){
            return sceneText2;
        }
        public void  setSceneText2(String SceneText2 ) {
            this.sceneText2 = sceneText2;
        }
//        SceneText3
        public String sceneText3;

        public String getSceneText3(){
            return sceneText3;
        }
        public void  setSceneText3(String SceneText3 ) {
            this.sceneText3 = sceneText3;
        }
//        SceneCharId
        public String sceneChar1Id;

        public String getSceneChar1Id(){
            return sceneChar1Id;
        }
        public void  setSceneChar1Id(String SceneChar1Id ) {
            this.sceneChar1Id = sceneChar1Id;
        }
//        SceneChar2Id
        public String sceneChar2Id;

        public String getSceneChar2Id(){
            return sceneChar2Id;
        }
        public void  setSceneChar2Id(String SceneChar2Id ) {
            this.sceneChar2Id = sceneChar2Id;
        }
//        sceneOption1Txt
        public String sceneOption1Txt;

        public String getSceneOption1Txt(){
            return sceneOption1Txt;
        }
        public void  setSceneOption1Txt(String SceneOption1Txt ) {
            this.sceneOption1Txt = sceneOption1Txt;
        }
//        SceneOption1Area
        public String sceneOption1Area;

        public String getSceneOption1Area(){
            return sceneOption1Area;
        }
        public void  setSceneOption1Area(String SceneOption1Area ) {
            this.sceneOption1Area = sceneOption1Area;
        }
//        SceneOption1SceneId
        public String sceneOption1SceneId;

        public String getSceneOption1SceneId(){
            return sceneOption1Area;
        }
        public void  setSceneOption1SceneId(String SceneOption1SceneId ) {
            this.sceneOption1SceneId = sceneOption1SceneId;
        }
        //        sceneOption2Txt
        public String sceneOption2Txt;

        public String getSceneOption2Txt(){
            return sceneOption2Txt;
        }
        public void  setSceneOption2Txt(String SceneOption2Txt ) {
            this.sceneOption2Txt = sceneOption2Txt;
        }
        //        SceneOption2Area
        public String sceneOption2Area;

        public String getSceneOption2Area(){
            return sceneOption2Area;
        }
        public void  setSceneOption2Area(String SceneOption2Area ) {
            this.sceneOption2Area = sceneOption2Area;
        }
        //        SceneOption2SceneId
        public String sceneOption2SceneId;

        public String getSceneOption2SceneId(){
            return sceneOption2Area;
        }
        public void  setSceneOption2SceneId(String SceneOption2SceneId ) {
            this.sceneOption2SceneId = sceneOption2SceneId;
        }
//      DefaultNextArea
public String defaultNextArea;

        public String getDefaultNextArea(){
            return defaultNextArea;
        }
        public void  setDefaultNextArea(String DefaultNextArea ) {
            this.defaultNextArea = defaultNextArea;
        }
//      DefaultNextScene
public String defaultNextScene;

        public String getDefaultNextScene(){
            return defaultNextScene;
        }
        public void  setDefaultNextScene(String DefaultNextScene ) {
            this.defaultNextScene = defaultNextScene;
        }
//        END SCENE VARIABLES
    }


