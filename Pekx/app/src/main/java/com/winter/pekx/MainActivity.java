package com.winter.pekx;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

//      Removes title bar.
        getSupportActionBar().hide();
//      Configures the buttons in the method below
        configureButtons();
        setButtonText();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setButtonText();
    }

    private void configureButtons(){
//      Variable initialization
        Button newGame = (Button) findViewById(R.id.newGame);
        Button loadGame = (Button) findViewById(R.id.loadGame);
        final Button buttonLess = (Button) findViewById(R.id.buttonLess);
        final Button buttonMore = (Button) findViewById(R.id.buttonMore);
        final Button textSizeButton = (Button) findViewById(R.id.textSizeButton);
        final Button musicButton = (Button) findViewById(R.id.musicToggle);

//      SWAPS TO PLAY SCREEN
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayActivity.class));
            }
        });

//      SWAPS TO LOAD SCREEN WITH SPECIAL DATA PASSED THROUGH
        final Intent intent = new Intent(MainActivity.this, SaveLoadActivity.class);
        intent.putExtra("From", "MainMenu");
        intent.putExtra("LoadSave", "Load");
        loadGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

//      Lowers font size and Raises it via changing shared preferences.
        buttonLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings =
                        getSharedPreferences("com.winter.pekx", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                int fontSize = Integer.parseInt(settings.getString("FONT_SIZE", "12"));
                if (fontSize > 6) {
                    fontSize -= 1;
                } else  {
                    buttonLess.setEnabled(false);
                }
                buttonMore.setEnabled(true);
                String fontSet = Integer.toString(fontSize);
                editor.putString("FONT_SIZE", fontSet);
                editor.apply();
                textSizeButton.setText("TEXT SIZE: " + fontSet);
            }
        });
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings =
                        getSharedPreferences("com.winter.pekx", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                int fontSize = Integer.parseInt(settings.getString("FONT_SIZE", "12"));
                if (fontSize < 18) {
                    fontSize += 1;
                } else  {
                    buttonMore.setEnabled(false);
                }
                buttonLess.setEnabled(true);
                String fontSet = Integer.toString(fontSize);
                editor.putString("FONT_SIZE", fontSet);
                editor.apply();
                textSizeButton.setText("TEXT SIZE: " + fontSet);
            }
        });

//      Mutes the music
        musicButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SharedPreferences settings =
                        getSharedPreferences("com.winter.pekx", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();

//              TOGGLES MUSIC ON OR OFF
                Boolean musicTog = settings.getBoolean("MUSIC_ON", true);
                if (musicTog == true)
                    musicTog = false;
                else
                    musicTog = true;
                editor.putBoolean("MUSIC_ON", musicTog);
                editor.apply();

//              SETS MUSIC BUTTON TEXT
                String musicText;
                if(musicTog == true)
                    musicText = "ON";
                else
                    musicText = "OFF";
                musicButton.setText("Music: " + musicText);
            }
        });

    }
//  SETS THE TEXT OF BUTTONS
    public void setButtonText()
    {
        final Button textSizeButton = (Button) findViewById(R.id.textSizeButton);
        final Button musicButton = (Button) findViewById(R.id.musicToggle);

//      SETS TEXT SIZE BUTTON
        SharedPreferences settings = getSharedPreferences("com.winter.pekx", Context.MODE_PRIVATE);
        String fontSize = settings.getString("FONT_SIZE", "12");
        textSizeButton.setText("TEXT SIZE: " + fontSize);

//      SET MUSIC BUTTON
        Boolean musicTog = settings.getBoolean("MUSIC_ON", true);
        String musicText;
        if(musicTog == true)
            musicText = "ON";
        else
            musicText = "OFF";
        musicButton.setText("Music: " + musicText);
    }
}

