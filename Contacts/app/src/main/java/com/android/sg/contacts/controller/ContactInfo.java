package com.android.sg.contacts.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.sg.contacts.R;

public class ContactInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        TextView name = (TextView) findViewById(R.id.et_contact_name);
        name.setText(Integer.toString(getIntent().getIntExtra("id_contact",-1)));
//
    }

    public void backButtonClick(View view) {
        Intent intent = new Intent(this, ContactsList.class);
        startActivity(intent);
    }
}
