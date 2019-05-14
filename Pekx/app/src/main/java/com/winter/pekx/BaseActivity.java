package com.winter.pekx;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;

public class BaseActivity extends AppCompatActivity {
    public void onStart() {
        super.onStart();
        try {
            SharedPreferences settings =
                    getSharedPreferences("com.winter.pekx", Context.MODE_PRIVATE);
            // Get the font size option.  We use "FONT_SIZE" as the key.
            // Make sure to use this key when you set the value in SharedPreferences.
            // We specify "12" as the default value, if it does not exist.
            String fontSizePref = settings.getString("FONT_SIZE", "12");
            boolean musicOnPref = settings.getBoolean("MUSIC_ON", true);
            // Select the proper theme ID.
            // These will correspond to your theme names as defined in themes.xml.
            int themeID = R.style.FontSize8;

            if (fontSizePref == "6") {
                themeID = R.style.FontSize6;
            }
            else if (fontSizePref == "7") {
                themeID = R.style.FontSize7;
            }
            else if (fontSizePref == "8") {
                themeID = R.style.FontSize8;
            }
            else if (fontSizePref == "9") {
                themeID = R.style.FontSize9;
            }
            else if (fontSizePref == "10") {
                themeID = R.style.FontSize10;
            }
            else if (fontSizePref == "11") {
                themeID = R.style.FontSize11;
            }
            else if (fontSizePref == "12") {
                themeID = R.style.FontSize12;
            }
            else if (fontSizePref == "13") {
                themeID = R.style.FontSize13;
            }
            else if (fontSizePref == "14") {
                themeID = R.style.FontSize14;
            }
            else if (fontSizePref == "15") {
                themeID = R.style.FontSize15;
            }
            else if (fontSizePref == "16") {
                themeID = R.style.FontSize16;
            }
            else if (fontSizePref == "17") {
                themeID = R.style.FontSize17;
            }
            else if (fontSizePref == "18") {
                themeID = R.style.FontSize18;
            }

            // Set the theme for the activity.
            setTheme(themeID);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
