package com.winter.pekx;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SaveLoadActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_load_menu);
        getIntent();
        String originFrom = getIntent().getStringExtra("From");
        String saveLoadNew = getIntent().getStringExtra("LoadSave");
//      Removes title bar.
        getSupportActionBar().hide();
//      Configures the buttons in the method below
        configureButtons(originFrom,saveLoadNew);
    }

    private void configureButtons(String originFromP,String saveLoadNewP){
        Button saveOneButton = (Button) findViewById(R.id.saveOneButton);
        Button saveTwoButton = (Button) findViewById(R.id.saveTwoButton);
        Button saveThreeButton = (Button) findViewById(R.id.saveThreeButton);
        Button saveFourButton = (Button) findViewById(R.id.saveFourButton);
        Button saveFiveButton = (Button) findViewById(R.id.saveFiveButton);
        Button saveSixButton = (Button) findViewById(R.id.saveSixButton);
        Button backButton = (Button) findViewById(R.id.backButton);
        final JSONInfo jsonInfo = new JSONInfo(getApplicationContext());

//      Sets the variables of where this came from and its use as a final variable to be used in the button on clicks
        final String originFrom = originFromP;
        final String saveLoadNew = saveLoadNewP;

        final Intent intent = new Intent(SaveLoadActivity.this, PlayActivity.class);

        saveOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("save", "0");
                jsonInfo.loadJSON(0,saveLoadNew);
                startActivity(new Intent(SaveLoadActivity.this, PlayActivity.class));
            }
        });

        saveTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("save", "1");
                jsonInfo.loadJSON(1,saveLoadNew);
                startActivity(new Intent(SaveLoadActivity.this, PlayActivity.class));
            }
        });
        saveThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("save", "2");
                jsonInfo.loadJSON(2,saveLoadNew);
                startActivity(new Intent(SaveLoadActivity.this, PlayActivity.class));
            }
        });
        saveFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("save", "3");
                jsonInfo.loadJSON(3,saveLoadNew);
                startActivity(new Intent(SaveLoadActivity.this, PlayActivity.class));
            }
        });
        saveFiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("save", "4");
                jsonInfo.loadJSON(4,saveLoadNew);
                startActivity(new Intent(SaveLoadActivity.this, PlayActivity.class));
            }
        });
        saveSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("save", "5");
                jsonInfo.loadJSON(5,saveLoadNew);
                startActivity(new Intent(SaveLoadActivity.this, PlayActivity.class));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
