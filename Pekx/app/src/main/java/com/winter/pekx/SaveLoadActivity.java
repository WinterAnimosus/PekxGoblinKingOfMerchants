package com.winter.pekx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SaveLoadActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_load_menu);

//      Removes title bar.
        getSupportActionBar().hide();
//      Configures the buttons in the method below
        configureButtons();
    }

    private void configureButtons(){
    }
}
