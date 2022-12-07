package com.example.uebung4;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String text = "Toast. Hoch die Tassen!";
                String name = ((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString();
                Toast toast = Toast.makeText(MainActivity.this, getString(R.string.toast_text, name), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    public void buttonClicked(View view) {
        Toast.makeText(MainActivity.this, getString(R.string.toast_other_button), Toast.LENGTH_LONG).show();
    }
}