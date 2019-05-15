package com.winter.pekx;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_game_menu);

//      Hides Task bar
        getSupportActionBar().hide();
//      Sets up buttons
        configureButtons();
        setButtonText();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setButtonText();
    }

    private void configureButtons(){
//      Initializes button
        Button resumeGame = (Button) findViewById(R.id.resumeGame);
        Button quitGame = (Button) findViewById(R.id.quitGame);
        Button loadGame = (Button) findViewById(R.id.loadGame);
        Button saveGame = (Button) findViewById(R.id.saveGame);
        final Button buttonLess = (Button) findViewById(R.id.buttonLess);
        final Button buttonMore = (Button) findViewById(R.id.buttonMore);
        final Button textSizeButton = (Button) findViewById(R.id.textSizeButton);
        final Button musicButton = (Button) findViewById(R.id.musicToggle);
//      SETS BUTTON TO GO TO MAIN MENU
        resumeGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        quitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        //      SWAPS TO LOAD / SAVE SCREEN WITH SPECIAL DATA PASSED THROUGH
        final Intent intentL = new Intent(MenuActivity.this, SaveLoadActivity.class);
        intentL.putExtra("From", "inGameMenu");
        intentL.putExtra("LoadSave", "Load");
        loadGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentL);
            }
        });
        final Intent intentS = new Intent(MenuActivity.this, SaveLoadActivity.class);
        intentS.putExtra("From", "inGameMenu");
        intentS.putExtra("LoadSave", "Save");
        loadGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentS);
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
                Boolean musicTog = settings.getBoolean("MUSIC_ON", true);
                if (musicTog == true)
                    musicTog = false;
                else
                    musicTog = true;
                editor.putBoolean("MUSIC_ON", musicTog);
                editor.apply();

                String musicText;
                if(musicTog == true)
                    musicText = "ON";
                else
                    musicText = "OFF";
                musicButton.setText("Music: " + musicText);
            }
        });
    }

    public void setButtonText()
    {
        final Button textSizeButton = (Button) findViewById(R.id.textSizeButton);
        final Button musicButton = (Button) findViewById(R.id.musicToggle);

        SharedPreferences settings = getSharedPreferences("com.winter.pekx", Context.MODE_PRIVATE);
        String fontSize = settings.getString("FONT_SIZE", "12");
        textSizeButton.setText("TEXT SIZE: " + fontSize);

        Boolean musicTog = settings.getBoolean("MUSIC_ON", true);
        String musicText;
        if(musicTog == true)
            musicText = "ON";
        else
            musicText = "OFF";
        musicButton.setText("Music: " + musicText);
    }
}
