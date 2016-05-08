package com.example.mahmoud.library;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyBooks extends AppCompatActivity {

    ListView myBookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_books);
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
        String [] book = null;

        ArrayList<String> booksList = null;
        try {
            InputStream inputStream = openFileInput("mybookfile.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                booksList = new ArrayList<String>();
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    booksList.add(receiveString.toString());
                }

                inputStream.close();
            }
        }
        catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        book = new String[booksList.size()];
        book = booksList.toArray(book);
        myBookList = (ListView) findViewById(R.id.myBookList);
        ArrayAdapter<String> books = new ArrayAdapter<String>(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                book
                );
        myBookList.setAdapter(books);
    }

}
