package com.winter.pekx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

//      Removes title bar.
        getSupportActionBar().hide();
//      Configures the buttons in the method below
        configureButtons();
    }
    private void configureButtons(){
//      Variable initialization
        Button newGame = (Button) findViewById(R.id.newGame);
        Button loadGame = (Button) findViewById(R.id.loadGame);

        Intent fromMainActivity = new Intent(MainActivity.this, SaveActivity.class);

//      SWAPS TO PLAY SCREEN
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayActivity.class));
            }
        });
    }
}
