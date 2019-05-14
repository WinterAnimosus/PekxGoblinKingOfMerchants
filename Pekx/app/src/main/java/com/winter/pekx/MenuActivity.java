package com.winter.pekx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_game_menu);

//      Hides Task bar
        getSupportActionBar().hide();
//      Sets up buttons
        configureButtons();
    }

    private void configureButtons(){
//      Initializes button
        Button resumeGame = (Button) findViewById(R.id.resumeGame);
//      SETS BUTTON TO GO TO MAIN MENU
        resumeGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
