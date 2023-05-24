package com.example.uebung5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton1(View v) {
        Intent intentActivity2 = new Intent(MainActivity.this, Activity2.class);
        startActivity(intentActivity2);
    }
}