package com.saiproject.app18;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/***
 *
 *
 *  PROJECT : Mastering Shared Preferences
 *
 *  - Use font sizes by referencing values in strings.xml
 *  - Create menu_main.xml to create menu for our app (@res/menu)
 *  - create preferences_files.xml to store the preferences for our app(@res/xml)
 *  - Use of intent to shift from main app to preferences menu
 *  - Change of fonts using external fonts downloaded at @assets/fonts
 *
 *
 *
 *
 *
 */
public class MainActivity extends AppCompatActivity {


    TextView txtNumber1;
    TextView txtNumber2;
    TextView txtNumber3;

    Typeface fontNumber1;
    Typeface fontNumber2;
    Typeface fontNumber3;


    String textView1Size;
    String textView2Size;
    String textView3Size;


    SharedPreferences sharedPreferences; //Save use preferences


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber1 = findViewById(R.id.txtNumber1);
        txtNumber2 = findViewById(R.id.txtNumber2);
        txtNumber3 = findViewById(R.id.txtNumber3);


        fontNumber1 = Typeface.createFromAsset(getAssets(),"fonts/Funky Signature.ttf");
        fontNumber2 = Typeface.createFromAsset(getAssets(),"fonts/Lelushka_Personal_use.otf");
        fontNumber3 = Typeface.createFromAsset(getAssets(),"fonts/Austere (DEMO).ttf");


        //Shared preferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    }


    // Configure Font of Text View 1

    public void specifyTheFontForTextView1(){


        boolean fontNumber1Text1Val;
        boolean fontNumber2Text1Val;
        boolean fontNumber3Text1Val;

        fontNumber1Text1Val = sharedPreferences.getBoolean("CHECKBOX_TEXT1_FONT1",false);    //Checkbox1 value key accessed (from preferences_files), default value is false
        fontNumber2Text1Val = sharedPreferences.getBoolean("CHECKBOX_TEXT1_FONT2",false);    //Checkbox2 value key accessed, default value is false
        fontNumber3Text1Val = sharedPreferences.getBoolean("CHECKBOX_TEXT1_FONT3",false);   //Checkbox3 value key accessed, default value is false



        if(fontNumber1Text1Val){
            txtNumber1.setTypeface(fontNumber1);
        }

        else if(fontNumber2Text1Val){
            txtNumber1.setTypeface(fontNumber2);
        }

        else if(fontNumber3Text1Val){
            txtNumber1.setTypeface(fontNumber3);
        }

    }

    // Configure Font of Text View 2

    public void specifyTheFontForTextView2(){


        boolean fontNumber1Text2Val;
        boolean fontNumber2Text2Val;
        boolean fontNumber3Text2Val;

        fontNumber1Text2Val = sharedPreferences.getBoolean("CHECKBOX_TEXT2_FONT1",false);    //Checkbox1 value key accessed (from preferences_files), default value is false
        fontNumber2Text2Val = sharedPreferences.getBoolean("CHECKBOX_TEXT2_FONT2",false);    //Checkbox2 value key accessed, default value is false
        fontNumber3Text2Val = sharedPreferences.getBoolean("CHECKBOX_TEXT2_FONT3",false);   //Checkbox3 value key accessed, default value is false



        if(fontNumber1Text2Val){
            txtNumber2.setTypeface(fontNumber1);
        }

        else if(fontNumber2Text2Val){
            txtNumber2.setTypeface(fontNumber2);
        }

        else if(fontNumber3Text2Val){
            txtNumber2.setTypeface(fontNumber3);
        }

    }

    //Configure Font of Text View 3

    public void specifyTheFontForTextView3(){


        boolean fontNumber1Text3Val;
        boolean fontNumber2Text3Val;
        boolean fontNumber3Text3Val;

        fontNumber1Text3Val = sharedPreferences.getBoolean("CHECKBOX_TEXT3_FONT1",false);    //Checkbox1 value key accessed (from preferences_files), default value is false
        fontNumber2Text3Val = sharedPreferences.getBoolean("CHECKBOX_TEXT3_FONT2",false);    //Checkbox2 value key accessed, default value is false
        fontNumber3Text3Val = sharedPreferences.getBoolean("CHECKBOX_TEXT3_FONT3",false);   //Checkbox3 value key accessed, default value is false



        if(fontNumber1Text3Val){
            txtNumber3.setTypeface(fontNumber1);
        }

        else if(fontNumber2Text3Val){
            txtNumber3.setTypeface(fontNumber2);
        }

        else if(fontNumber3Text3Val){
            txtNumber3.setTypeface(fontNumber3);
        }

    }


    //Set TextView 1 size
    public void setTextView1Size(){

        textView1Size = sharedPreferences.getString("FONT_SIZE_TEXT1","20"); //The value is stored in strings.xml which is a string.

        txtNumber1.setTextSize(Float.parseFloat(textView1Size));                                    //Convert into float


    }

    //Set TextView 2 size
    public void setTextView2Size(){

        textView2Size = sharedPreferences.getString("FONT_SIZE_TEXT2","20"); //The value is stored in strings.xml which is a string.

        txtNumber2.setTextSize(Float.parseFloat(textView2Size));                                    //Convert into float


    }

    //Set TextView 3 size
    public void setTextView3Size(){

        textView3Size = sharedPreferences.getString("FONT_SIZE_TEXT3","20"); //The value is stored in strings.xml which is a string.

        txtNumber3.setTextSize(Float.parseFloat(textView3Size));                                    //Convert into float


    }




    // OnResume sharedPreferences is called


    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "On Resume is called  ", Toast.LENGTH_SHORT).show();

        specifyTheFontForTextView1(); //This configures it as per choice
        specifyTheFontForTextView2();
        specifyTheFontForTextView3();


        setTextView1Size();
        setTextView2Size();
        setTextView3Size();
    }


    //Create options menu from menu_main.xml

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);

        return true;
    }



    //On selecting an item from the menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){


            case R.id.settings:

                Intent intent = new Intent(this,PreferencesActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);


    }

}
