package com.example.mahmoud.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Control extends AppCompatActivity {

    Button addBooks;
    Button showAllBooks;
    Button showMyBooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
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

        addBooks = (Button) findViewById(R.id.addButton);
        showAllBooks = (Button) findViewById(R.id.showAllButton);
        showMyBooks = (Button) findViewById(R.id.showMyButton);
        addBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(Control.this, AddBook.class);
                startActivity(next);
            }
        });
        showAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(Control.this, ShowAllBooks.class);
                startActivity(next);
            }
        });
        showMyBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(Control.this, MyBooks.class);
                startActivity(next);
            }
        });
    }

}
