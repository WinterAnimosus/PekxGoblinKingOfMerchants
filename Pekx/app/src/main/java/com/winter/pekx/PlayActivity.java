package com.winter.pekx;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PlayActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_screen);

//      Hides Task bar
        getSupportActionBar().hide();
//      Sets up buttons
        configureButtons();
        setScene();

    }

    private void configureButtons(){
//      Initializes button
        ImageButton menuButton = (ImageButton) findViewById(R.id.menuButton);
        ImageView backgroundView = (ImageView) findViewById(R.id.backgroundView);
        EditText storyText = (EditText) findViewById(R.id.storyText);

//        final int save = Integer.parseInt(getIntent().getStringExtra("save"));
//        final JSONInfo jsonInfo = new JSONInfo(getApplicationContext());

//      SETS BUTTON TO GO TO MENU
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this, MenuActivity.class));
            }
        });
        backgroundView.setClickable(true);
        backgroundView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                jsonInfo.loadJSON(save, "next");
            }
        });
    }

    private void setScene() {
//      Gets the elements needed to change
        ImageView backgroundView = (ImageView) findViewById(R.id.backgroundView);
        EditText storyText = (EditText) findViewById(R.id.storyText);
        ImageView charImage1 = (ImageView) findViewById(R.id.charImage1);
        ImageView charImage2 = (ImageView) findViewById(R.id.charImage2);

//      Calls the json and gets data
        JSONInfo jsonInfo = new JSONInfo(getApplicationContext());
//        getIntent();
//        int save = Integer.parseInt(getIntent().getStringExtra("save"));
        jsonInfo.loadJSON(0,"load");
        String sceneData[] = jsonInfo.getVariables("all");

//      Sets the things
//        String mDrawableName = sceneData[5];
//        int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
//        backgroundView.setImageResource(resID);

        String text;
        text = "You wake to the dawn of a new day with a sore back. Guess I can’t be too ungrateful, it’s my only valuable thing left."+ " You look over your cart and think for a minute."+" I guess I should start moving I have to get to the town and try to make some money off the stupid humans. ";
        storyText.setText(text);

    }

}
