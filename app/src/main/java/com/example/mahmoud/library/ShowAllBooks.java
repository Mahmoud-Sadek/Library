package com.example.mahmoud.library;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ShowAllBooks extends AppCompatActivity {

    ListView booksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_books);
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
        ArrayList<String> bookList = null;
        try {
            FileInputStream fIn = openFileInput("bookfile.txt");
            InputStreamReader isr = new InputStreamReader(fIn);
            char[] inputBuffer = new char[100];

            bookList = new ArrayList<String>();
            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                bookList.add(readString);
                inputBuffer = new char[100];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        book = new String[bookList.size()];
        book = bookList.toArray(book);
        booksList = (ListView) findViewById(R.id.BookList);
        ArrayAdapter<String> books = new ArrayAdapter<String>(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                book

                );
        booksList.setAdapter(books);
        final String[] finalBook = book;
        booksList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String myBook = finalBook[i];
                FileOutputStream fOut = null;
                try {
                    fOut = openFileOutput("mybookfile.txt", MODE_APPEND);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fOut);
                    outputStreamWriter.write(myBook);
                    outputStreamWriter.close();
                    Toast.makeText(getBaseContext(), "Add To My Books!", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
