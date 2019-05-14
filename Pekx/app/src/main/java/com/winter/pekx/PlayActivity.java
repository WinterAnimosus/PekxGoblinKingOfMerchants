package com.winter.pekx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PlayActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_screen);

//      Hides Task bar
        getSupportActionBar().hide();
//      Sets up buttons
        configureButtons();
    }

    private void configureButtons(){
//      Initializes button
        ImageButton menuButton = (ImageButton) findViewById(R.id.menuButton);
//      SETS BUTTON TO GO TO MENU
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this, MenuActivity.class));
            }
        });
    }
}
