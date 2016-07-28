package com.android.sg.contacts.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.sg.contacts.R;
import com.android.sg.contacts.model.ContactListLoad;
import com.android.sg.contacts.model.ModelContactListFull;

import java.util.ArrayList;

public class ContactInfo extends AppCompatActivity {

    public TextView name;
    public TextView surName;
    public TextView phone;
    public TextView skills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        name = (TextView) findViewById(R.id.et_contact_name);
        surName = (TextView) findViewById(R.id.et_contact_surname);
        phone = (TextView) findViewById(R.id.et_contact_phone);
        skills = (TextView) findViewById(R.id.et_contact_skills);
        editTextReadOnly();
        editTextLoadData();
    }

    public void backButtonClick(View view) {
        Intent intent = new Intent(this, ContactsList.class);
        startActivity(intent);
    }

    protected void editButtonCreate() {
//        LinearLayout containerContact = new LinearLayout(this);
//        containerContact.setOrientation(LinearLayout.VERTICAL);
//        containerContact.setPadding(5,5,5,5);
//        containerContact.setBackgroundResource(R.color.colorBacgroundContact);
//        containerContact.layout(3,3,3,3);
//        listContacts.addView(containerContact, containerParams);
//        Button btnNew = new Button(this);
//        btnNew.setText("test button");
//        listContacts.addView(btnNew);
    }

    protected void editTextReadOnly() {
        int type = View.LAYER_TYPE_NONE;
        name.setInputType(type);
        surName.setInputType(type);
        phone.setInputType(type);
        skills.setInputType(type);
    }

    private void editTextLoadData() {
        ArrayList<ModelContactListFull> contactListFull = new ContactListLoad().loadFullList();
        ModelContactListFull contact = contactListFull.get(-1 * getIntent().getIntExtra("id_contact", -1) - 1);
        name.setText(contact.getName());
        surName.setText(contact.getSurName());
        phone.setText(contact.getPhone());
        skills.setText(contact.skillsAsString());
    }

}
