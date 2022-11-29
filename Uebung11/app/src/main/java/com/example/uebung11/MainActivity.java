package com.example.uebung11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    protected static final String EXTRA_PERSON_NAME = "personName";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextTextPersonName);
    }

    public void onClickButtonService(View v) {
        String personName = editText.getText().toString();
        Log.i(TAG, String.fromat("Got from EditText: %s", personName));
        Intent serviceIntent = new Intent(MainActivity.this, ExampleService.class);
        serviceIntent.putExtra(EXTRA_PERSON_NAME, personName);
        startService(serviceIntent);
    }
}