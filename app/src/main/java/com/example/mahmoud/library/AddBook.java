package com.example.mahmoud.library;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class AddBook extends AppCompatActivity {

    EditText bookName;
    Button addBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bookName = (EditText) findViewById(R.id.bookName);
        addBook = (Button) findViewById(R.id.addButton);
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String book = bookName.getText().toString();
                FileOutputStream fOut = null;
                try {
                    fOut = openFileOutput("bookfile.txt", MODE_PRIVATE);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fOut);
                    outputStreamWriter.write(book);
                    outputStreamWriter.close();

                    Toast.makeText(getBaseContext(), "Saved Successfully!", Toast.LENGTH_SHORT).show();
                    bookName.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
