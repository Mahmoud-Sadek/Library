package com.example.mahmoud.library;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName ;
    EditText userPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.userName);
        userPass = (EditText) findViewById(R.id.pass);

        Button saveButton = (Button) findViewById(R.id.login);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", userName.getText().toString());
                editor.putString("pass", userPass.getText().toString());
                editor.commit();
                Intent next = new Intent(MainActivity.this, Control.class);
                startActivity(next);
            }
        });

    }
}
